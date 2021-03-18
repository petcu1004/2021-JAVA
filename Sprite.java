import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite { //화면에서 움직이는 그림을 나타내는 클래스
	//공통적으로 쓰이는 걸 이 클래스에 다 정의함

	protected int x; //우주선 위치 x
	protected int y; //우주선 위치 y
	protected int width;
	protected int height;
	protected boolean visible;
	protected Image image; //우주선 이미지 변수

	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}

	protected void loadImage(String imageName) { //이미지 파일을 읽어오는 것
		ImageIcon ii = new ImageIcon(imageName); 
		image = ii.getImage(); //이미지 아이콘 추출
	}

	protected void getImageDimensions() {
		width = image.getWidth(null); //이미지 사이즈 그대로의 너비
		height = image.getHeight(null); //이미지 사이즈 그대로의 높이
	}

	public Image getImage() {
		return image; //이미지 반환
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