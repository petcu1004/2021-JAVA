import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.Rectangle;


//�׸��� �׷����� Ŭ����
public class Board extends JPanel implements ActionListener, KeyListener {

	private Timer timer; //Ÿ�̸� Ŭ���� �������� ����(Ŭ���� �������� �� �� �ִ� ����)-Ÿ�̸� ����� �����ϴ� Ŭ����
	private Spaceship ship; //Spaceship Ŭ���� �������� ����(Ŭ���� �������� �� �� �ִ� ����)

	private ArrayList<Alien> a=new ArrayList<>();
	
	private final int DELAY = 5; //Ÿ�̸��� ���� �ð� ������-��ȣ���

	public Board() { //������
		addKeyListener(this); //Ű���带 ������ �� ȣ��Ǵ� �޼��带 ������ �ִ� �������̽�
		setFocusable(true); //Ű���� �̺�Ʈ�� �ޱ� ���ؼ��� ��Ŀ�� �̺�Ʈ�� �ʿ���
		setBackground(Color.BLACK); //���ȭ���� ���������� ����

		ship = new Spaceship(450,500); //���ּ� ��ü ��ġ (��ü ����)
		
		
		for(int i=0;i<5;i++) {
			a.add(new Alien(50+i*100, 20));
		}
		
		timer = new Timer(DELAY, this); //�ֱ������� �׸��� �׷�����ϱ⶧���� Ÿ�̸� �ʿ�
		timer.start(); //Ÿ�̸� ��ŸƮ
	}

	@Override
	//������Ʈ�� �ٽ� �׸� �ʿ䰡 ���� ������ �ڹ� �ý��ۿ� ���Ͽ� ȣ��Ǵ� �޼ҵ�
	public void paintComponent(Graphics g) { //JPanel���׷��ִ� �޼���
		super.paintComponent(g); //JPanel���� ��ӹ��� ������� ����
		Graphics2D g2d = (Graphics2D) g; //�̹����� �׸��� ��ü ����
		g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this); //���ּ��� x, y��ǥ(��ġ)�� �����ͼ� �׸��� ��
		
		for(int i=0;i<a.size();i++) {
			g2d.drawImage(a.get(i).getImage(), a.get(i).getX(), a.get(i).getY(), this); //���ּ��� x, y��ǥ(��ġ)�� �����ͼ� �׸��� ��
		}

		//ship�� Spaceship�� Ŭ�������� ������ �Ŵϱ� �� Ŭ���� ���� �޼��� ��� ����
		if( ship.getMissile() != null )//�̻����� ���� ���(�����̽��ٸ� ������ �̻����� ������ ���)
			for(int j=0;j<ship.getMissile().size();j++)
				g2d.drawImage(ship.getMissile().get(j).getImage(), ship.getMissile().get(j).getX(), ship.getMissile().get(j).getY(), this);//�̻��� ��ġ�� �� �̹����� �׸�
		
		Toolkit.getDefaultToolkit().sync(); //���� �׸� ���� ȭ�鿡 ��� ǥ���ض��� �ϴ� ��(����ȭ),(�⺻ ��Ŷ ��ü�� ����)
	}

	@Override
	//�׼� �̺�Ʈ�� ó���ϰ� ������ actionPerformed �޼ҵ� ����
	public void actionPerformed(ActionEvent e) { //Ÿ�̸ӷ� ���� �̺�Ʈ�� �߻��� ������ ȣ��

		ship.move(); //���ּ��� ������
		

		for(int j=0;j<a.size();j++)
		{
			if(j%2==0) {
				a.get(j).move_even();
			}
			if(j%2 !=0) {
				a.get(j).move_odd();
			}
			
		}

		if( ship.getMissile() != null ) //�̻����� ���� ���(�����̽��ٸ� ������ �̻����� ������ ���)
		{
			for(int j=0;j<ship.getMissile().size();j++)
				ship.m.get(j).move();	
			
			for(int i=0;i<ship.getMissile().size();i++)
			if(ship.m.get(i).getY()<-10)
				ship.m.remove(i);
		}
			
		
		ArrayList<Alien> aa=new ArrayList<>();

		
		for(int j=0;j<ship.getMissile().size();j++)
		{
			for(int i=0;i<a.size();i++) {
				if(ship.getMissile().get(j).rec().intersects(a.get(i).rec()))
				{
					a.get(i).visible=false;
					aa.add(a.get(i));
					
				}
			}
		}
			
		for(Alien i:aa)
			a.remove(i);
		
		if(a.size()==0 )
			System.exit(0);
		

			  

			
		
		
		repaint(); //ȭ�鿡 �ٽ� �׸����� ȣ��->paintComponent()�� ȣ����.
	}

	private void showMessageDialog(Object object, String string) {
		// TODO Auto-generated method stub
		
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