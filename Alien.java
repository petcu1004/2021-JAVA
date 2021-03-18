import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.*;


public class Alien extends Sprite{
	//Sprite Ŭ������ ��ӹ��� Alien Ŭ���� ����
	private int ALIEN_SPEED_even=7; //����Ʈ ���� �ε��� ��ȣ�� ¦���� ���, �ܰ����� �ӵ�
	private int ALIEN_SPEED_odd=5; //����Ʈ ���� �ε��� ��ȭ�� Ȧ���� ���, �ܰ��� �ӵ�
	int dx=2, dy=2; //�ܰ����� �����ӿ� ���� ����

	public Alien(int x, int y) { //Alien Ŭ������ ������
		super(x, y); //�θ� Ŭ������ �����ڸ� �ҷ� �ܰ����� x, y��ǥ ��ġ�� �°� �׸�
		loadImage("alien.png");//a.png ������ ������ �̹��� �ε��Ŵ
	}

	public void move_even() { //����Ʈ ���� �ε��� ��ȣ�� ¦���� ���
		x+=ALIEN_SPEED_even; //7�� �ӵ��� ������
		if(x<=0||x>=850) { //������ �������� �����̵��� ��
			ALIEN_SPEED_even = -ALIEN_SPEED_even; //�ش� ��ǥ���� �� �����̸� �ݴ�������� �����̰� ������ �ٲ�
		}
	}
		
	public void move_odd() { //����Ʈ ���� �ε��� ��ȣ�� Ȧ���� ���
		y=70; //�ܰ����� y���� 70���� �����Ͽ� ¦������ �ִ� �ܰ��κ��� �Ʒ� ��ġ�ϰ� ��.
		x+=ALIEN_SPEED_odd;//5�� �ӵ��� ������
		if(x<=0||x>=850) { //������ �������� �����̵��� ��
			ALIEN_SPEED_odd = -ALIEN_SPEED_odd; //�ش� ��ǥ���� �� �����̸� �ݴ�������� �����̰� ������ �ٲ�
		}
	}
	
	public Rectangle rec() { //�ܰ����� �̹����� �簢�� ���� �ȿ� ����
		Rectangle r=new Rectangle(this.getX(), this.getY(),100, 37); //�簢�� ��ü ����
		return r;//�簢�� ��ȯ
	}
}
