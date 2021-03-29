import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.*;
import java.awt.Rectangle;

public class Alien extends Sprite{
	
	//Sprite 클래스를 상속받은 Alien 클래스 구현
   private int ALIEN_SPEED_even=2; //리스트 내의 인덱스 번호가 짝수일 경우, 외계인의 속도
   private int ALIEN_SPEED_odd=1; //리스트 내의 인덱스 번화가 홀수일 경우, 외계인 속도
   int dx=1, dy=1, c;//외계인의 움직임에 대한 변수
   
   int delay; //총알이 계속 나가지 않게 딜레이를 줌
   int num=1400; //외계인의 움직임에 영향을 주는 변수(각도)
   long create = System.currentTimeMillis();//현재 시간을 create변수에 할당


   public Alien(int x, int y, int count) {//Alien 클래스의 생성자
      super(x, y);//부모 클래스의 생성자를 불러 외계인을 x, y좌표 위치에 맞게 그림
      c=count; //짝수 홀수 구분하기 위한 변수
      loadImage("D:/alien.png");//alien.png 파일을 가져와 이미지 로드시킴
      Random r = new Random(); //외계인이 총알을 랜덤하게 쏘도록 랜덤함수 생성
      this.delay = r.nextInt(3000);//3000분의1초의 딜레이를 갖도록 함
  }


   public void move() { //외계인의 움직임을 짝수 홀수로 구분해주는 메서드
	   if (c%2==0) //리스트 내의 인덱스 번호가 짝수인 경우
	   {
		   //외계인의 움직임이 곡선으로 둥글게 움직이도록 함
		   x=(int) (Math.cos((double)num/100)*100+100)+c*100; //x좌표는 cos함수를 통해 설정 
		   y=(int) (Math.sin((double)num/100)*100+100); //y좌표는 sin함수를 통해 설정

		   num++; //시계 방향으로 돌도록 설정
		   
			if(x<=0||x>=850) { //윈도우 내에서만 움직이도록 함
				
				ALIEN_SPEED_even = -ALIEN_SPEED_even; //해당 좌표보다 더 움직이면 반대방향으로 움직이게 방향을 바꿈
			}   
	   }
	   else {//리스트 내의 인덱스 번호가 홀수인 경우
		   x=(int) (Math.cos((double)num/100)*100+100)+c*100; //x좌표는 cos함수를 통해 설정 
		   y=(int) (Math.sin((double)num/100)*100+100); //y좌표는 sin함수를 통해 설정

		   num--; //시계 반대 방향으로 돌도록 설정
		   
			if(x<=0||x>=850) { //윈도우 내에서만 움직이도록 함
				ALIEN_SPEED_odd = -ALIEN_SPEED_odd; //해당 좌표보다 더 움직이면 반대방향으로 움직이게 방향을 바꿈
		      }
	   }
   }
   
   public void shoot() { // 외계인이 총알을 쏘는 메서드 생성
	   long now = System.currentTimeMillis(); //현재 시간 값을 now 변수에 설정
	   
	   
	   if (now - create > delay ) { //현재 시간 값을 갖고 있는 now에서 이전 시간의 값을 갖고 있는 create를 빼서 딜레이 값보다 크다면
		   Board.aBullet.add(new Bullet(this.x + 45, this.y+68)) ; //총알 객체 생성됨
		   create = now;//계속 랜덤하게 총알이 나오게 하기 위해
		   delay = new Random().nextInt(3000);//랜덤 값을 할당
	   }
   }
    
   public Rectangle rec() {//외계인의 이미지를 사각형 범위 안에 넣음
      Rectangle r=new Rectangle(this.getX(), this.getY(),92, 68);//사각형 객체 생성
      return r;//사각형 반환
   }
   
}