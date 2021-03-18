import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Missile extends Sprite {

	private final int MISSILE_SPEED = 5; //상수
	int dx = 2, dy = 2; //미사일 속도

	public Missile(int x, int y) { //생성자
		super(x+5, y-40); //부모 클래스의 생성자를 불러 미사일을 x, y좌표 위치에 맞게 그림
		loadImage("m.png"); 
	}

	public void move() { //미사일이 앞으로 나가는 것처럼 보이게 하는 메서드
		y -= MISSILE_SPEED;  //주어진 미사일의 속도에 맞게 위로 움직임
		if (y < 0) { //미사일이 화면 밖을 벗어나게 되면
			visible = false; //더이상 미사일이 보이지 않게 함.
			
		}
	}
	
	public Rectangle rec() {
		Rectangle r=new Rectangle(this.getX(), this.getY(),30, 71);
		return r;
	}
	
	
}