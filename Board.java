import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer; 
import java.util.ArrayList;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

//�׸��� �׷����� Ŭ����
public class Board extends JPanel implements ActionListener, KeyListener {
	//JPanel Ŭ������ ��ӹ��� Board Ŭ�������� �׼Ǹ����ʿ� Ű������(�������̽�)�� ������.

   private Timer timer; //Ÿ�̸� Ŭ���� �������� ����(Ŭ���� �������� �� �� �ִ� ����)-Ÿ�̸� ����� �����ϴ� Ŭ����
   private Spaceship ship;  //Spaceship Ÿ���� �������� ����(Ŭ���� �������� �� �� �ִ� ����)
   
   private ArrayList<Alien> a=new ArrayList<>(); //Alien Ÿ���� ArrayList ����(Ŭ���� �������� �� �� �ִ� ����)
   public static ArrayList<Bullet> aBullet = new ArrayList<>(); //Bullet Ÿ���� ArrayList ����
   
   private ArrayList<Alien> aa=new ArrayList<>();//�ܰ��� ��ü�� �̻��ϰ� ������ ���� ����Ʈ-���ڸ��� �ٷ� remove��Ű�� ������ ����� ������ ���� ������.
   private ArrayList<Missile> mm=new ArrayList<>();//�̻��� ��ü�� �ܰ��ΰ� ������ ���� ����Ʈ/������ ȭ���� ������ �Ǹ� ���� ����Ʈ-�ٷ� remove��Ű�� ������ ����� ������ ���� ������.
   private ArrayList<Bullet> bb = new ArrayList<>(); //�Ѿ��� ��ü�� ���ּ��� ������ ���� ����Ʈ
   
   private final int DELAY = 5; //Ÿ�̸��� ���� �ð� ������-��ȣ���

   Image bkg; //���ȭ�� �̹����� ���� �̹��� ���� ����
   int count=0; //������ ���� ���� ���� ���� ���� �� �ʱ�ȭ
   
   public Board() { //������
      addKeyListener(this); //Ű���带 ������ �� ȣ��Ǵ� �޼��带 ������ �ִ� �������̽�
      setFocusable(true); //Ű���� �̺�Ʈ�� �ޱ� ���ؼ��� ��Ŀ�� �̺�Ʈ�� �ʿ���
      
      ImageIcon back=new ImageIcon("D:/background.jpg"); //background.jpg ������ �����ͼ� ��ü ����
      bkg=back.getImage(); //�̹��� ������ ��ü�� bkg�� �Ҵ�

      ship = new Spaceship(450,500); //���ּ� ��ü ��ġ (��ü ����)
      
    //�ܰ��� ��ü�� 5�� ����
      for(int i=0;i<7;i++) 
         a.add(new Alien(50+i*100, 20, i));//��ü�� �����ϴ� ���ÿ� ArrayList�� �Ҵ�
      
      timer = new Timer(DELAY, this); //�ֱ������� �׸��� �׷�����ϱ⶧���� Ÿ�̸� �ʿ�
      timer.start(); //Ÿ�̸� ��ŸƮ
   }

   @Override
   //������Ʈ�� �ٽ� �׸� �ʿ䰡 ���� ������ �ڹ� �ý��ۿ� ���Ͽ� ȣ��Ǵ� �޼ҵ�
   public void paintComponent(Graphics g) { //JPanel���׷��ִ� �޼���
      super.paintComponent(g); //JPanel���� ��ӹ��� ������� ����
      Graphics2D g2d = (Graphics2D) g; //�̹����� �׸��� ��ü g2d ����
      g2d.drawImage(bkg, 0, 0, this); //���ȭ��
      g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this); //���ּ��� x, y��ǥ(��ġ)�� �����ͼ� �׸��� ��

      for(int i=0;i<a.size();i++) {//�ܰ����� �̹����� �׸��� for��(�ܰ����� ���ִ� ArrayList(a)�� ũ�⸸ŭ �ݺ�)
         g2d.drawImage(a.get(i).getImage(), a.get(i).getX(), a.get(i).getY(), this); //arrayList���� �� �ε����� �ش��ϴ� �ܰ����� �̸���, x, y��ǥ(��ġ)�� �����ͼ� �׸�
      }
      
      for(int i = 0; i < aBullet.size();i ++) { //�Ѿ��� ������ ũ�⸸ŭ �ݺ��ϴ� for��
    	  g2d.setColor(Color.red); //�Ѿ� ��ü�� ���� ���������� ����
    	  g2d.fillOval(aBullet.get(i).x, aBullet.get(i).y, aBullet.get(i).size, aBullet.get(i).size); //�Ѿ��� ��������� ������
    	  
      }
      
      //ship�� Spaceship�� Ŭ�������� ������ �Ŵϱ� �� Ŭ���� ���� �޼��� ��� ����->Spaceship Ŭ������ SpriteŬ���带 ��ӹ޾ұ� ������ Sprite Ŭ���� ���� �޼��� ��� ����
      if( ship.getMissile() != null )//�̻����� ���� ���(�̻��� ��ü�� null�� ������ �����̽��� ������ ���ο� ��ü�� �����Ǿ� ArrayList m�� ���� ������ null�� �ƴ� ���� ��)
         for(int j=0;j<ship.getMissile().size();j++)//�̻��� ��ü�� ��� ArrayList m�� ũ�⸸ŭ(�����̽��ٸ� ���� Ƚ����ŭ) for���� ������
            g2d.drawImage(ship.getMissile().get(j).getImage(), ship.getMissile().get(j).getX(), ship.getMissile().get(j).getY(), this);//�̻��� �̹����� �׸�
      
      Toolkit.getDefaultToolkit().sync(); //���� �׸� ���� ȭ�鿡 ��� ǥ���ض��� �ϴ� ��(����ȭ),(�⺻ ��Ŷ ��ü�� ����)
   }

   @Override
   //�׼� �̺�Ʈ�� ó���ϰ� ������ actionPerformed �޼ҵ� ����
   public void actionPerformed(ActionEvent e) { //Ÿ�̸ӷ� ���� �̺�Ʈ�� �߻��� ������ ȣ��

      ship.move(); //���ּ��� ������
      
      for(int j=0;j<a.size();j++) {
    	  a.get(j).move() ;//�ܰ����� �����̰� �ϴ� move�޼��� ȣ��
    	  a.get(j).shoot();//�ܰ����� �Ѿ��� ��� shoot�޼��� ȣ��
      }
      
      
      for(int m=0;m<aBullet.size();m++) { //�Ѿ��� ������ ũ�⸸ŭ �ݺ�
    	  aBullet.get(m).move();//�ܰ��� �� �Ѿ��� �����̰��ϴ� move�޼��� ȣ�� 
    	  
    	  if(aBullet.get(m).rec().intersects(ship.getX(), ship.getY(), 57, 120))//�Ѿ˰� ���ּ��� ��´ٸ�
    	  {
    		  JOptionPane.showMessageDialog(null, count+"������ ����� �����ϴ� (����:70)", "���� ����", JOptionPane.INFORMATION_MESSAGE); //���� ���� �޽��� ���
    		  bb.add(aBullet.get(m)); //������ �Ѿ� ��ü�� ������� �ʾұ� ������ ������Ű�� ���� ����Ʈ�� ����
    		  System.exit(0);//�ý��� ����

    	  }
    	  
    	  else {
              if(aBullet.get(m).y>900) //������ ������ ������ �Ǹ�
              {
                 aBullet.get(m).visible=false; //�Ѿ��� �Ⱥ��̰� �ϰ�
                 bb.add(aBullet.get(m)); //������ �Ѿ� ��ü�� ������Ű�� ���� ����ư�� ����
              }
    	  }
      }
      
      if( ship.getMissile() != null )  //�̻����� ���� ���(�̻��� ��ü�� null�� ������ �����̽��� ������ ���ο� ��ü�� �����Ǿ� ArrayList m�� ���� ������ null�� �ƴ� ���� ��)
      {
         for(int j=0;j<ship.getMissile().size();j++) //�̻��� ��ü�� ��� ArrayList m�� ũ�⸸ŭ(�����̽��ٸ� ���� Ƚ����ŭ) for���� ������
            ship.m.get(j).move();  //�̻����� y�������� ������
      }
         
      //(���� �ݺ���)
      for(int j=0;j<ship.getMissile().size();j++)//�����̽��ٸ� ���� Ƚ����ŭ �ݺ�
      {
         for(int i=0;i<a.size();i++) {//�ܰ����� ������ŭ �ݺ�
            if(ship.getMissile().get(j).rec().intersects(a.get(i).rec()))//Rectangle()�� ����Ͽ� �̻��� ��ü �̹����� �ܰ��� ��ü �̹����� ��� ���
            {
            	count+=10;
               mm.add(ship.m.get(j));//�ܰ��ΰ� ���� �̻��� ��ü�� mm ����Ʈ�� �Ҵ�
               aa.add(a.get(i));//���� �ܰ��� ��ü�� aa����Ʈ�� �Ҵ�
               i=100; //�ݺ����� ���������� ���� i�� 100�Ҵ�
               j=100; //�ݺ����� ���������� ���� j�� 100�Ҵ�
            }
         }
      }
         
      for(Alien i:aa)//ArrayList aa�� �� ��� �ܰ��� ��ü���� ����(�޸𸮸� ���� �������� �ʰ� �ϱ� ���ؼ�)
         a.remove(i); //����Ʈ ���� �ִ� ��ü ����
      
      for(Missile j:mm)//ArrayList mm�� �� ��� �̻��� ��ü���� ����(�޸𸮸� ���� �������� �ʰ� �ϱ� ���ؼ�)
         ship.m.remove(j);//����Ʈ ���� �ִ� ��ü ����
      
      
      for(Bullet k:bb) //ArrayList bb�� �� ��� �Ѿ� ��ü���� ����(�޸𸮸� ���� �������� �ʰ� �ϱ� ���ؼ�)
    	  aBullet.remove(k); //����Ʈ ���� �ִ� ��ü ����
    	  
      if(a.size()==0 ) {//�ܰ����� ��� ������
    	  JOptionPane.showMessageDialog(null, count+"������ ����� �̰���ϴ� (����:70)", "���� ����", JOptionPane.INFORMATION_MESSAGE); //���� ���� �޽��� ���
         System.exit(0);//�ý��� ����
      }

      repaint(); //ȭ�鿡 �ٽ� �׸����� ȣ��->paintComponent()�� ȣ����.
   }

   @Override
   public void keyReleased(KeyEvent e) { //����ڰ� Ű���� ���� ������ ��쿡 ȣ��
      ship.keyReleased(e);
   }

   @Override
   public void keyPressed(KeyEvent e) { //����ڰ� Ű�� ������ ��쿡 ȣ��
      ship.keyPressed(e);
   }

   @Override
   public void keyTyped(KeyEvent arg0) { //����ڰ� ���ڸ� �Է����� ��쿡 ȣ��
   }
}