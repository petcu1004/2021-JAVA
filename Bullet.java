import java.awt.Rectangle;

public class Bullet { //�ܰ����� ��� �Ѿ��� �����ϴ� Ŭ����
	int size; //�Ѿ� ������
	int x, y; //�Ѿ� ��ġ
	boolean visible; //�Ѿ��� ������ â�� ���̰� �� �������� ������ ���ϴ� ����
	
	//������
	public Bullet(int x, int y) {
		this.x=x; //�Ѿ��� x��ǥ�� ��ġ
		this.y=y; //�Ѿ��� y��ǥ�� ��ġ
		this.size = 10; //�Ѿ��� ũ��� 10���� ����
	}
	
	public void move() { //�Ѿ��� �������� �����ϴ� �޼���
		this.y += 1; //�Ʒ��� 1�� ������
	}
	
	public Rectangle rec() { //�Ѿ˰� ���ּ��� �´� ������ �����ϱ� ���� �ʿ��� �޼���
		//�Ѿ��� �̹����� �簢�� ���� �ȿ� ����
		Rectangle r=new Rectangle(this.x, this.y, this.size, this.size); //�Ѿ˿� ���õ� �簢�� ��ü ����
		return r; //�簢�� ��ȯ
	}
}
