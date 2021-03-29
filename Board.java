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

//그림이 그려지는 클래스
public class Board extends JPanel implements ActionListener, KeyListener {
	//JPanel 클래스를 상속받은 Board 클래스에서 액션리스너와 키리스너(인터페이스)를 구현함.

   private Timer timer; //타이머 클래스 참조변수 선언(클래스 내에서만 쓸 수 있는 변수)-타이머 기능을 수행하는 클래스
   private Spaceship ship;  //Spaceship 타입인 참조변수 선언(클래스 내에서만 쓸 수 있는 변수)
   
   private ArrayList<Alien> a=new ArrayList<>(); //Alien 타입인 ArrayList 선언(클래스 내에서만 쓸 수 있는 변수)
   public static ArrayList<Bullet> aBullet = new ArrayList<>(); //Bullet 타입인 ArrayList 선언
   
   private ArrayList<Alien> aa=new ArrayList<>();//외계인 객체가 미사일과 닿으면 넣을 리스트-닿자마자 바로 remove시키면 오류가 생기기 때문에 따로 생성함.
   private ArrayList<Missile> mm=new ArrayList<>();//미사일 객체가 외계인과 닿으면 넣을 리스트/윈도우 화면을 나가게 되면 넣을 리스트-바로 remove시키면 오류가 생기기 때문에 따로 생성함.
   private ArrayList<Bullet> bb = new ArrayList<>(); //총알의 객체가 우주선과 닿으면 넣을 리스트
   
   private final int DELAY = 5; //타이머의 일정 시간 딜레이-기호상수

   Image bkg; //배경화면 이미지를 넣을 이미지 변수 선언
   int count=0; //점수를 세기 위해 만든 변수 선언 및 초기화
   
   public Board() { //생성자
      addKeyListener(this); //키보드를 눌렀을 때 호출되는 메서드를 가지고 있는 인터페이스
      setFocusable(true); //키보드 이벤트를 받기 위해서는 포커스 이벤트가 필요함
      
      ImageIcon back=new ImageIcon("D:/background.jpg"); //background.jpg 파일을 가져와서 객체 생성
      bkg=back.getImage(); //이미지 아이콘 객체를 bkg에 할당

      ship = new Spaceship(450,500); //우주선 객체 위치 (객체 생성)
      
    //외계인 객체를 5개 생성
      for(int i=0;i<7;i++) 
         a.add(new Alien(50+i*100, 20, i));//객체를 생성하는 동시에 ArrayList에 할당
      
      timer = new Timer(DELAY, this); //주기적으로 그림을 그려줘야하기때문에 타이머 필요
      timer.start(); //타이머 스타트
   }

   @Override
   //컴포넌트를 다시 그릴 필요가 있을 때마다 자바 시스템에 의하여 호출되는 메소드
   public void paintComponent(Graphics g) { //JPanel에그려주는 메서드
      super.paintComponent(g); //JPanel에서 상속받은 멤버변수 참조
      Graphics2D g2d = (Graphics2D) g; //이미지를 그리는 객체 g2d 생성
      g2d.drawImage(bkg, 0, 0, this); //배경화면
      g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this); //우주선의 x, y좌표(위치)를 가져와서 그리는 것

      for(int i=0;i<a.size();i++) {//외계인의 이미지를 그리는 for문(외계인이 들어가있는 ArrayList(a)의 크기만큼 반복)
         g2d.drawImage(a.get(i).getImage(), a.get(i).getX(), a.get(i).getY(), this); //arrayList내의 각 인덱스에 해당하는 외계인의 이마지, x, y좌표(위치)를 가져와서 그림
      }
      
      for(int i = 0; i < aBullet.size();i ++) { //총알이 생성된 크기만큼 반복하는 for문
    	  g2d.setColor(Color.red); //총알 객체의 색을 빨간색으롯 설정
    	  g2d.fillOval(aBullet.get(i).x, aBullet.get(i).y, aBullet.get(i).size, aBullet.get(i).size); //총알을 원모양으로 생성함
    	  
      }
      
      //ship은 Spaceship의 클래스에서 가져온 거니까 그 클래스 내의 메서드 사용 가능->Spaceship 클래스는 Sprite클래드를 상속받았기 때문에 Sprite 클래스 내의 메서드 사용 가능
      if( ship.getMissile() != null )//미사일이 생긴 경우(미사일 객체가 null인 값에서 스페이스를 누르면 새로운 객체가 생성되어 ArrayList m에 들어가기 때문에 null이 아닌 값이 됨)
         for(int j=0;j<ship.getMissile().size();j++)//미사일 객체를 담는 ArrayList m의 크기만큼(스페이스바를 누른 횟수만큼) for문을 돌려서
            g2d.drawImage(ship.getMissile().get(j).getImage(), ship.getMissile().get(j).getX(), ship.getMissile().get(j).getY(), this);//미사일 이미지를 그림
      
      Toolkit.getDefaultToolkit().sync(); //지금 그린 것을 화면에 즉시 표시해라라고 하는 것(동기화),(기본 툴킷 객체를 얻음)
   }

   @Override
   //액션 이벤트를 처리하고 싶으면 actionPerformed 메소드 정의
   public void actionPerformed(ActionEvent e) { //타이머로 인해 이벤트가 발생할 때마다 호출

      ship.move(); //우주선을 움직임
      
      for(int j=0;j<a.size();j++) {
    	  a.get(j).move() ;//외계인을 움직이게 하는 move메서드 호출
    	  a.get(j).shoot();//외계인이 총알을 쏘는 shoot메서드 호출
      }
      
      
      for(int m=0;m<aBullet.size();m++) { //총알이 생성된 크기만큼 반복
    	  aBullet.get(m).move();//외계인 쏜 총알을 움직이게하는 move메서드 호출 
    	  
    	  if(aBullet.get(m).rec().intersects(ship.getX(), ship.getY(), 57, 120))//총알과 우주선이 닿는다면
    	  {
    		  JOptionPane.showMessageDialog(null, count+"점으로 당신이 졌습니다 (만점:70)", "게임 종료", JOptionPane.INFORMATION_MESSAGE); //게임 종료 메시지 출력
    		  bb.add(aBullet.get(m)); //생성된 총알 객체는 사라지지 않았기 때문에 삭제시키기 위해 리스트에 넣음
    		  System.exit(0);//시스템 종료

    	  }
    	  
    	  else {
              if(aBullet.get(m).y>900) //윈도우 밖으로 나가게 되면
              {
                 aBullet.get(m).visible=false; //총알을 안보이게 하고
                 bb.add(aBullet.get(m)); //생성된 총알 객체를 삭제시키기 위해 리스튼에 넣음
              }
    	  }
      }
      
      if( ship.getMissile() != null )  //미사일이 생긴 경우(미사일 객체가 null인 값에서 스페이스를 누르면 새로운 객체가 생성되어 ArrayList m에 들어가기 때문에 null이 아닌 값이 됨)
      {
         for(int j=0;j<ship.getMissile().size();j++) //미사일 객체를 담는 ArrayList m의 크기만큼(스페이스바를 누른 횟수만큼) for문을 돌려서
            ship.m.get(j).move();  //미사일이 y방향으로 움직임
      }
         
      //(이중 반복문)
      for(int j=0;j<ship.getMissile().size();j++)//스페이스바를 누른 횟수만큼 반복
      {
         for(int i=0;i<a.size();i++) {//외계인의 갯수만큼 반복
            if(ship.getMissile().get(j).rec().intersects(a.get(i).rec()))//Rectangle()를 사용하여 미사일 객체 이미지와 외계인 객체 이미지가 닿는 경우
            {
            	count+=10;
               mm.add(ship.m.get(j));//외계인과 닿은 미사일 객체를 mm 리스트에 할당
               aa.add(a.get(i));//닿은 외계인 객체를 aa리스트에 할당
               i=100; //반복문을 빠져나가기 위해 i에 100할당
               j=100; //반복문을 빠져나가기 위해 j에 100할당
            }
         }
      }
         
      for(Alien i:aa)//ArrayList aa에 들어간 모든 외계인 객체들을 제거(메모리를 많이 차지하지 않게 하기 위해서)
         a.remove(i); //리스트 내에 있는 객체 삭제
      
      for(Missile j:mm)//ArrayList mm에 들어간 모든 미사일 객체들을 제거(메모리를 많이 차지하지 않게 하기 위해서)
         ship.m.remove(j);//리스트 내에 있는 객체 삭제
      
      
      for(Bullet k:bb) //ArrayList bb에 들어간 모든 총알 객체들을 제거(메모리를 많이 차지하지 않게 하기 위해서)
    	  aBullet.remove(k); //리스트 내에 있는 객체 삭제
    	  
      if(a.size()==0 ) {//외계인이 모두 죽으면
    	  JOptionPane.showMessageDialog(null, count+"점으로 당신이 이겼습니다 (만점:70)", "게임 종료", JOptionPane.INFORMATION_MESSAGE); //게임 종료 메시지 출력
         System.exit(0);//시스템 종료
      }

      repaint(); //화면에 다시 그리도록 호출->paintComponent()를 호출함.
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