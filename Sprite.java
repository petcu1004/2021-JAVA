import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite { //ȭ�鿡�� �����̴� �׸��� ��Ÿ���� Ŭ����
	//���������� ���̴� �� �� Ŭ������ �� ������

	protected int x; //���ּ� ��ġ x
	protected int y; //���ּ� ��ġ y
	protected int width;
	protected int height;
	protected boolean visible;
	protected Image image; //���ּ� �̹��� ����

	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}

	protected void loadImage(String imageName) { //�̹��� ������ �о���� ��
		ImageIcon ii = new ImageIcon(imageName); 
		image = ii.getImage(); //�̹��� ������ ����
	}

	protected void getImageDimensions() {
		width = image.getWidth(null); //�̹��� ������ �״���� �ʺ�
		height = image.getHeight(null); //�̹��� ������ �״���� ����
	}

	public Image getImage() {
		return image; //�̹��� ��ȯ
	}

	public int getX() { //���� ��ġ(x)�� ��ȯ���ִ� ������ �޼��� (�ʵ尪 �б�)
		return x;
	}

	public int getY() { //���� ��ġ(y)�� ��ȯ���ִ� ������ �޼��� (�ʵ尪 �б�)
		return y;
	}

	public boolean isVisible() { //�����ӿ� ������ ������ Ȯ���� �� �ִ� ������ �޼���
		return visible;
	}

	public void setVisible(Boolean visible) { 
		this.visible = visible;
	}
}