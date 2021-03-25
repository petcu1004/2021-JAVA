import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite { //화면에서 움직이는 그림을 나타내는 클래스
	//객체가 공통적으로 쓰는 메서드를 이 클래스에 다 정의함

	protected int x; //어떤 객체의 위치 x
	protected int y; //어떤 객체의 위치 y
	protected int width; //어떤 객체의 너비
	protected int height; //어떤 객체의 높이
	protected boolean visible; //어떤 객체를 화면에 보일지 유뮤 결정
	protected Image image; //어떤 객체의 이미지 변수

	public Sprite(int x, int y) { //Sprite 클래스의 생성자
		this.x = x; //해당 객체의 x좌표
		this.y = y; //해당 객체의 y좌표
		visible = true; //화면에 보이게 설정
	}

	protected void loadImage(String imageName) { //이미지 파일을 읽어오는 것
		ImageIcon ii = new ImageIcon(imageName); //이미지 객체 생성
		image = ii.getImage(); //이미지 아이콘 추출
	}

	protected void getImageDimensions() {
		width = image.getWidth(null); //이미지 사이즈 그대로의 너비
		height = image.getHeight(null); //이미지 사이즈 그대로의 높이
	}

	public Image getImage() { //이미지 반환
		return image; 
	}

	public int getX() { //현재 위치(x)를 반환해주는 접근자 메서드 (필드값 읽기)
		return x;
	}

	public int getY() { //현재 위치(y)를 반환해주는 접근자 메서드 (필드값 읽기)
		return y;
	}

	public boolean isVisible() { //프레임에 보여줄 것인지 확인할 수 있는 접근자 메서드
		return visible;
	}

	public void setVisible(Boolean visible) { 
		this.visible = visible;
	}
}