import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;


//�׸��� �׷����� Ŭ����
public class Board extends JPanel implements ActionListener, KeyListener {
	//JPanel Ŭ������ ��ӹ��� Board Ŭ�������� �׼Ǹ����ʿ� Ű������(�������̽�)�� ������.

	private Timer timer; //Ÿ�̸� Ÿ���� �������� ����(Ŭ���� �������� �� �� �ִ� ����)-Ÿ�̸� ����� �����ϴ� Ŭ����
	private Spaceship ship; //Spaceship Ÿ���� �������� ����(Ŭ���� �������� �� �� �ִ� ����)

	private ArrayList<Alien> a=new ArrayList<>(); //Alien Ÿ���� ArrayList ����(Ŭ���� �������� �� �� �ִ� ����)
	
	private final int DELAY = 5; //Ÿ�̸��� ���� �ð� ������-��ȣ���

	public Board() { //Board Ŭ������ ������
		addKeyListener(this); //Ű���带 ������ �� ȣ��Ǵ� �޼��带 ������ �ִ� �������̽�
		setFocusable(true); //Ű���� �̺�Ʈ�� �ޱ� ���ؼ��� ��Ŀ�� �̺�Ʈ�� �ʿ���
		setBackground(Color.BLACK); //���ȭ���� ���������� ����

		ship = new Spaceship(450,500); //���ּ� ��ü ��ġ (��ü ����)
		
		//�ܰ��� ��ü�� 5�� ����
		for(int i=0;i<5;i++) {
			a.add(new Alien(50+i*100, 20)); //��ü�� �����ϴ� ���ÿ� ArrayList�� �Ҵ�
		}
		
		timer = new Timer(DELAY, this); //�ֱ������� �׸��� �׷�����ϱ⶧���� Ÿ�̸� �ʿ�
		timer.start(); //Ÿ�̸� ��ŸƮ
	}

	@Override
	//������Ʈ�� �ٽ� �׸� �ʿ䰡 ���� ������ �ڹ� �ý��ۿ� ���Ͽ� ȣ��Ǵ� �޼ҵ�
	public void paintComponent(Graphics g) { //JPanel���׷��ִ� �޼���
		super.paintComponent(g); //JPanel���� ��ӹ��� ������� ����
		Graphics2D g2d = (Graphics2D) g; //�̹����� �׸��� ��ü g2d ����
		g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this); //���ּ��� �̹���, x, y��ǥ(��ġ)�� �����ͼ� �׸�
		
		for(int i=0;i<a.size();i++) { //�ܰ����� �̹����� �׸��� for��(�ܰ����� ���ִ� ArrayList(a)�� ũ�⸸ŭ �ݺ�)
			g2d.drawImage(a.get(i).getImage(), a.get(i).getX(), a.get(i).getY(), this); //arrayList���� �� �ε����� �ش��ϴ� �ܰ����� �̸���, x, y��ǥ(��ġ)�� �����ͼ� �׸�
		}

		//ship�� Spaceship�� Ŭ�������� ������ �Ŵϱ� �� Ŭ���� ���� �޼��� ��� ����->Spaceship Ŭ������ SpriteŬ���带 ��ӹ޾ұ� ������ Sprite Ŭ���� ���� �޼��� ��� ����
		if( ship.getMissile() != null )//�̻����� ���� ���(�̻��� ��ü�� null�� ������ �����̽��� ������ ���ο� ��ü�� �����Ǿ� ArrayList m�� ���� ������ null�� �ƴ� ���� ��)
			for(int j=0;j<ship.getMissile().size();j++) //�̻��� ��ü�� ��� ArrayList m�� ũ�⸸ŭ(�����̽��ٸ� ���� Ƚ����ŭ) for���� ������
				g2d.drawImage(ship.getMissile().get(j).getImage(), ship.getMissile().get(j).getX(), ship.getMissile().get(j).getY(), this);//�̻��� �̹����� �׸�
		
		Toolkit.getDefaultToolkit().sync(); //���� �׸� ���� ȭ�鿡 ��� ǥ���ض��� �ϴ� ��(����ȭ),(�⺻ ��Ŷ ��ü�� ����)
	}

	@Override
	//�׼� �̺�Ʈ�� ó���ϰ� ������ actionPerformed �޼ҵ� ����
	public void actionPerformed(ActionEvent e) { //Ÿ�̸ӷ� ���� �̺�Ʈ�� �߻��� ������ ȣ��

		ship.move(); //���ּ��� ������
		//�ܰ����� �������� ¦��, Ȧ���� ������
		for(int j=0;j<a.size();j++) 
		{
			if(j%2==0) //¦���� ���
				a.get(j).move_even(); //Alien Ŭ���� ���� move_even()�Լ� ����
			
			if(j%2 !=0) //Ȧ���� ���
				a.get(j).move_odd(); //Alien Ŭ���� ���� move_odd()�Լ� ����
		}

		ArrayList<Alien> aa=new ArrayList<>(); //�ܰ��� ��ü�� �̻��ϰ� ������ ���� ����Ʈ-���ڸ��� �ٷ� remove��Ű�� ������ ����� ������ ���� ������.
		ArrayList<Missile> mm=new ArrayList<>(); //�̻��� ��ü�� �ܰ��ΰ� ������ ���� ����Ʈ/������ ȭ���� ������ �Ǹ� ���� ����Ʈ-�ٷ� remove��Ű�� ������ ����� ������ ���� ������.
		
		if( ship.getMissile() != null ) //�̻����� ���� ���(�̻��� ��ü�� null�� ������ �����̽��� ������ ���ο� ��ü�� �����Ǿ� ArrayList m�� ���� ������ null�� �ƴ� ���� ��)
		{
			for(int j=0;j<ship.getMissile().size();j++) //�̻��� ��ü�� ��� ArrayList m�� ũ�⸸ŭ(�����̽��ٸ� ���� Ƚ����ŭ) for���� ������
				ship.m.get(j).move(); //�̻����� y�������� ������
			
			for(int i=0;i<ship.getMissile().size();i++)//�̻��� ��ü�� ��� ArrayList m�� ũ�⸸ŭ(�����̽��ٸ� ���� Ƚ����ŭ) for���� ������
			if(ship.m.get(i).getY()<-70) //�ش� �̻����� ������ â�� ������
			{
				ship.m.get(i).visible=false; //�̻����� ����� �ִ� ArrayList�� ��ü�� ȭ�鿡 �Ⱥ��̰� ��
				mm.add(ship.m.get(i)); //�ܰ��ΰ� ���� �̻��� ��ü�� mm ����Ʈ�� �Ҵ�
			}
		}
			
		//(���� �ݺ���)
		for(int j=0;j<ship.getMissile().size();j++) //�����̽��ٸ� ���� Ƚ����ŭ �ݺ�
		{
			for(int i=0;i<a.size();i++) { //�ܰ����� ������ŭ �ݺ�
				if(ship.getMissile().get(j).rec().intersects(a.get(i).rec())) //Rectangle()�� ����Ͽ� �̻��� ��ü �̹����� �ܰ��� ��ü �̹����� ��� ���
				{
					a.get(i).visible=false; //�ܰ��� �̹����� �Ⱥ��̰� ����
					aa.add(a.get(i)); //���� �ܰ��� ��ü�� aa����Ʈ�� �Ҵ�
					ship.m.get(i).visible=false; //�̻����� ����� �ִ� ArrayList�� ��ü�� ȭ�鿡 �Ⱥ��̰� ��
					mm.add(ship.m.get(i)); //�ܰ��ΰ� ���� �̻��� ��ü�� mm ����Ʈ�� �Ҵ�
				}
			}
		}
			
		for(Alien i:aa) //ArrayList aa�� �� ��� �ܰ��� ��ü���� ����(�޸𸮸� ���� �������� �ʰ� �ϱ� ���ؼ�)
			a.remove(i);
		
		for(Missile j:mm) //ArrayList mm�� �� ��� �̻��� ��ü���� ����(�޸𸮸� ���� �������� �ʰ� �ϱ� ���ؼ�)
			ship.m.remove(j);
		
		if(a.size()==0) //�ܰ����� ��� ������
			System.exit(0); //�ý��� ����
		
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