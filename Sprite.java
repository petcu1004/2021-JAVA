import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite { //ȭ�鿡�� �����̴� �׸��� ��Ÿ���� Ŭ����
	//��ü�� ���������� ���� �޼��带 �� Ŭ������ �� ������

	protected int x; //� ��ü�� ��ġ x
	protected int y; //� ��ü�� ��ġ y
	protected int width; //� ��ü�� �ʺ�
	protected int height; //� ��ü�� ����
	protected boolean visible; //� ��ü�� ȭ�鿡 ������ ���� ����
	protected Image image; //� ��ü�� �̹��� ����

	public Sprite(int x, int y) { //Sprite Ŭ������ ������
		this.x = x; //�ش� ��ü�� x��ǥ
		this.y = y; //�ش� ��ü�� y��ǥ
		visible = true; //ȭ�鿡 ���̰� ����
	}

	protected void loadImage(String imageName) { //�̹��� ������ �о���� ��
		ImageIcon ii = new ImageIcon(imageName); //�̹��� ��ü ����
		image = ii.getImage(); //�̹��� ������ ����
	}

	protected void getImageDimensions() {
		width = image.getWidth(null); //�̹��� ������ �״���� �ʺ�
		height = image.getHeight(null); //�̹��� ������ �״���� ����
	}

	public Image getImage() { //�̹��� ��ȯ
		return image; 
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