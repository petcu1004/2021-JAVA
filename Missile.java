import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Missile extends Sprite {

	private final int MISSILE_SPEED = 5; //���
	int dx = 2, dy = 2; //�̻��� �ӵ�

	public Missile(int x, int y) { //������
		super(x+5, y-40); //�θ� Ŭ������ �����ڸ� �ҷ� �̻����� x, y��ǥ ��ġ�� �°� �׸�
		loadImage("m.png"); 
	}

	public void move() { //�̻����� ������ ������ ��ó�� ���̰� �ϴ� �޼���
		y -= MISSILE_SPEED;  //�־��� �̻����� �ӵ��� �°� ���� ������
		if (y < 0) { //�̻����� ȭ�� ���� ����� �Ǹ�
			visible = false; //���̻� �̻����� ������ �ʰ� ��.
			
		}
	}
	
	public Rectangle rec() {
		Rectangle r=new Rectangle(this.getX(), this.getY(),30, 71);
		return r;
	}
	
	
}