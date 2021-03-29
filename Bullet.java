import java.awt.Rectangle;

public class Bullet { //외계인이 쏘는 총알을 구현하는 클래스
	int size; //총알 사이즈
	int x, y; //총알 위치
	boolean visible; //총알이 윈도우 창에 보이게 할 것인지의 유무를 정하는 변수
	
	//생성자
	public Bullet(int x, int y) {
		this.x=x; //총알의 x좌표의 위치
		this.y=y; //총알의 y좌표의 위치
		this.size = 10; //총알의 크기는 10으로 설정
	}
	
	public void move() { //총알의 움직임을 구현하는 메서드
		this.y += 1; //아래로 1씩 내려감
	}
	
	public Rectangle rec() { //총알과 우주선이 맞는 구역을 설정하기 위해 필요한 메서드
		//총알의 이미지를 사각형 범위 안에 넣음
		Rectangle r=new Rectangle(this.x, this.y, this.size, this.size); //총알에 관련된 사각형 객체 생성
		return r; //사각형 반환
	}
}
