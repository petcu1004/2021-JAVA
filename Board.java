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


//그림이 그려지는 클래스
public class Board extends JPanel implements ActionListener, KeyListener {

	private Timer timer; //타이머 클래스 참조변수 선언(클래스 내에서만 쓸 수 있는 변수)-타이머 기능을 수행하는 클래스
	private Spaceship ship; //Spaceship 클래스 참조변수 선언(클래스 내에서만 쓸 수 있는 변수)

	private ArrayList<Alien> a=new ArrayList<>();
	
	private final int DELAY = 5; //타이머의 일정 시간 딜레이-기호상수

	public Board() { //생성자
		addKeyListener(this); //키보드를 눌렀을 때 호출되는 메서드를 가지고 있는 인터페이스
		setFocusable(true); //키보드 이벤트를 받기 위해서는 포커스 이벤트가 필요함
		setBackground(Color.BLACK); //배경화면을 검은색으로 설정

		ship = new Spaceship(450,500); //우주선 객체 위치 (객체 생성)
		
		
		for(int i=0;i<5;i++) {
			a.add(new Alien(50+i*100, 20));
		}
		
		timer = new Timer(DELAY, this); //주기적으로 그림을 그려줘야하기때문에 타이머 필요
		timer.start(); //타이머 스타트
	}

	@Override
	//컴포넌트를 다시 그릴 필요가 있을 때마다 자바 시스템에 의하여 호출되는 메소드
	public void paintComponent(Graphics g) { //JPanel에그려주는 메서드
		super.paintComponent(g); //JPanel에서 상속받은 멤버변수 참조
		Graphics2D g2d = (Graphics2D) g; //이미지를 그리는 객체 생성
		g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this); //우주선의 x, y좌표(위치)를 가져와서 그리는 것
		
		for(int i=0;i<a.size();i++) {
			g2d.drawImage(a.get(i).getImage(), a.get(i).getX(), a.get(i).getY(), this); //우주선의 x, y좌표(위치)를 가져와서 그리는 것
		}

		//ship은 Spaceship의 클래스에서 가져온 거니까 그 클래스 내의 메서드 사용 가능
		if( ship.getMissile() != null )//미사일이 생긴 경우(스페이스바를 눌러서 미사일이 생겼을 경우)
			for(int j=0;j<ship.getMissile().size();j++)
				g2d.drawImage(ship.getMissile().get(j).getImage(), ship.getMissile().get(j).getX(), ship.getMissile().get(j).getY(), this);//미사일 위치를 얻어서 이미지를 그림
		
		Toolkit.getDefaultToolkit().sync(); //지금 그린 것을 화면에 즉시 표시해라라고 하는 것(동기화),(기본 툴킷 객체를 얻음)
	}

	@Override
	//액션 이벤트를 처리하고 싶으면 actionPerformed 메소드 정의
	public void actionPerformed(ActionEvent e) { //타이머로 인해 이벤트가 발생할 때마다 호출

		ship.move(); //우주선을 움직임
		

		for(int j=0;j<a.size();j++)
		{
			if(j%2==0) {
				a.get(j).move_even();
			}
			if(j%2 !=0) {
				a.get(j).move_odd();
			}
			
		}

		if( ship.getMissile() != null ) //미사일이 생긴 경우(스페이스바를 눌러서 미사일이 생겼을 경우)
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
		

			  

			
		
		
		repaint(); //화면에 다시 그리도록 호출->paintComponent()를 호출함.
	}

	private void showMessageDialog(Object object, String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) { //사용자가 키에서 손을 떼었을 경우에 호출
		ship.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) { //사용자가 키에 눌렀을 경우에 호출
		ship.keyPressed(e);
	}

	@Override
	public void keyTyped(KeyEvent arg0) { //사용자가 글자를 입력했을 경우에 호출
	}
}