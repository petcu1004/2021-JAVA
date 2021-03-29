import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Missile extends Sprite {
	//Sprite Ŭ������ ��ӹ��� MissileŬ���� ����
   private final int MISSILE_SPEED = 5; //��ȣ ���
   int dx = 1, dy = 1; //�̻����� �����ӿ� ���� ����

   public Missile(int x, int y) { //������
      super(x+22, y); //�θ� Ŭ������ �����ڸ� �ҷ� �̻����� x, y��ǥ ��ġ�� �°� �׸�
      loadImage("D:/missile.png"); //missile.png ������ ������ �̹��� �ε��Ŵ
   }

   public void move() { //�̻����� ������ ������ ��ó�� ���̰� �ϴ� �޼���
      y -= MISSILE_SPEED;  //�־��� �̻����� �ӵ��� �°� ���� ������
      if (y < 0) { //�̻����� ȭ�� ���� ����� �Ǹ�
         visible = false; //���̻� �̻����� ������ �ʰ� ��.   
      }
   }
   
   public Rectangle rec() {//�̻����� �̹����� �簢�� ���� �ȿ� ����
      Rectangle r=new Rectangle(this.getX(), this.getY(),47, 51);//�簢�� ��ü ����
      return r;//�簢�� ��ȯ
   }
}