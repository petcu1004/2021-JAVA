import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Missile extends Sprite {
	//Sprite Ŭ������ ��ӹ��� MissileŬ���� ����

	private final int MISSILE_SPEED = 5; //��ȣ ���
	int dx = 2, dy = 2; //�̻����� �����ӿ� ���� ����

	public Missile(int x, int y) { //������
		super(x+5, y-40); //�θ� Ŭ������ �����ڸ� �ҷ� �̻����� x, y��ǥ ��ġ�� �°� �׸�
		loadImage("missile.png"); //m.png ������ ������ �̹��� �ε��Ŵ
	}

	public void move() { //�̻����� ������ ������ ��ó�� ���̰� �ϴ� �޼���
		y -= MISSILE_SPEED;  //�־��� �̻����� �ӵ��� �°� ���� ������
		if (y < 0) { //�̻����� ȭ�� ���� ����� �Ǹ�
			visible = false; //���̻� �̻����� ������ �ʰ� ��.
		}
	}
	
	public Rectangle rec() { //�̻����� �̹����� �簢�� ���� �ȿ� ����
		Rectangle r=new Rectangle(this.getX(), this.getY(),30, 71); //�簢�� ��ü ����
		return r; //�簢�� ��ȯ
	}
}