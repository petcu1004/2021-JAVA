import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.*;


public class Alien extends Sprite{
	//Sprite 클래스를 상속받은 Alien 클래스 구현
	private int ALIEN_SPEED_even=7; //리스트 내의 인덱스 번호가 짝수일 경우, 외계인의 속도
	private int ALIEN_SPEED_odd=5; //리스트 내의 인덱스 번화가 홀수일 경우, 외계인 속도
	int dx=2, dy=2; //외계인의 움직임에 대한 변수

	public Alien(int x, int y) { //Alien 클래스의 생성자
		super(x, y); //부모 클래스의 생성자를 불러 외계인을 x, y좌표 위치에 맞게 그림
		loadImage("alien.png");//a.png 파일을 가져와 이미지 로드시킴
	}

	public void move_even() { //리스트 내의 인덱스 번호가 짝수인 경우
		x+=ALIEN_SPEED_even; //7의 속도로 움직임
		if(x<=0||x>=850) { //윈도우 내에서만 움직이도록 함
			ALIEN_SPEED_even = -ALIEN_SPEED_even; //해당 좌표보다 더 움직이면 반대방향으로 움직이게 방향을 바꿈
		}
	}
		
	public void move_odd() { //리스트 내의 인덱스 번호가 홀수인 경우
		y=70; //외계인의 y축을 70으로 설정하여 짝수번에 있는 외계인보다 아래 위치하게 함.
		x+=ALIEN_SPEED_odd;//5의 속도로 움직임
		if(x<=0||x>=850) { //윈도우 내에서만 움직이도록 함
			ALIEN_SPEED_odd = -ALIEN_SPEED_odd; //해당 좌표보다 더 움직이면 반대방향으로 움직이게 방향을 바꿈
		}
	}
	
	public Rectangle rec() { //외계인의 이미지를 사각형 범위 안에 넣음
		Rectangle r=new Rectangle(this.getX(), this.getY(),100, 37); //사각형 객체 생성
		return r;//사각형 반환
	}
}
