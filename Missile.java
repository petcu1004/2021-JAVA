import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Missile extends Sprite {
	//Sprite 클래스를 상속받은 Missile클래스 구현
   private final int MISSILE_SPEED = 5; //기호 상수
   int dx = 1, dy = 1; //미사일의 움직임에 대한 변수

   public Missile(int x, int y) { //생성자
      super(x+22, y); //부모 클래스의 생성자를 불러 미사일을 x, y좌표 위치에 맞게 그림
      loadImage("D:/missile.png"); //missile.png 파일을 가져와 이미지 로드시킴
   }

   public void move() { //미사일이 앞으로 나가는 것처럼 보이게 하는 메서드
      y -= MISSILE_SPEED;  //주어진 미사일의 속도에 맞게 위로 움직임
      if (y < 0) { //미사일이 화면 밖을 벗어나게 되면
         visible = false; //더이상 미사일이 보이지 않게 함.   
      }
   }
   
   public Rectangle rec() {//미사일의 이미지를 사각형 범위 안에 넣음
      Rectangle r=new Rectangle(this.getX(), this.getY(),47, 51);//사각형 객체 생성
      return r;//사각형 반환
   }
}