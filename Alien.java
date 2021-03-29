import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.*;
import java.awt.Rectangle;

public class Alien extends Sprite{
	
	//Sprite Ŭ������ ��ӹ��� Alien Ŭ���� ����
   private int ALIEN_SPEED_even=2; //����Ʈ ���� �ε��� ��ȣ�� ¦���� ���, �ܰ����� �ӵ�
   private int ALIEN_SPEED_odd=1; //����Ʈ ���� �ε��� ��ȭ�� Ȧ���� ���, �ܰ��� �ӵ�
   int dx=1, dy=1, c;//�ܰ����� �����ӿ� ���� ����
   
   int delay; //�Ѿ��� ��� ������ �ʰ� �����̸� ��
   int num=1400; //�ܰ����� �����ӿ� ������ �ִ� ����(����)
   long create = System.currentTimeMillis();//���� �ð��� create������ �Ҵ�


   public Alien(int x, int y, int count) {//Alien Ŭ������ ������
      super(x, y);//�θ� Ŭ������ �����ڸ� �ҷ� �ܰ����� x, y��ǥ ��ġ�� �°� �׸�
      c=count; //¦�� Ȧ�� �����ϱ� ���� ����
      loadImage("D:/alien.png");//alien.png ������ ������ �̹��� �ε��Ŵ
      Random r = new Random(); //�ܰ����� �Ѿ��� �����ϰ� ��� �����Լ� ����
      this.delay = r.nextInt(3000);//3000����1���� �����̸� ������ ��
  }


   public void move() { //�ܰ����� �������� ¦�� Ȧ���� �������ִ� �޼���
	   if (c%2==0) //����Ʈ ���� �ε��� ��ȣ�� ¦���� ���
	   {
		   //�ܰ����� �������� ����� �ձ۰� �����̵��� ��
		   x=(int) (Math.cos((double)num/100)*100+100)+c*100; //x��ǥ�� cos�Լ��� ���� ���� 
		   y=(int) (Math.sin((double)num/100)*100+100); //y��ǥ�� sin�Լ��� ���� ����

		   num++; //�ð� �������� ������ ����
		   
			if(x<=0||x>=850) { //������ �������� �����̵��� ��
				
				ALIEN_SPEED_even = -ALIEN_SPEED_even; //�ش� ��ǥ���� �� �����̸� �ݴ�������� �����̰� ������ �ٲ�
			}   
	   }
	   else {//����Ʈ ���� �ε��� ��ȣ�� Ȧ���� ���
		   x=(int) (Math.cos((double)num/100)*100+100)+c*100; //x��ǥ�� cos�Լ��� ���� ���� 
		   y=(int) (Math.sin((double)num/100)*100+100); //y��ǥ�� sin�Լ��� ���� ����

		   num--; //�ð� �ݴ� �������� ������ ����
		   
			if(x<=0||x>=850) { //������ �������� �����̵��� ��
				ALIEN_SPEED_odd = -ALIEN_SPEED_odd; //�ش� ��ǥ���� �� �����̸� �ݴ�������� �����̰� ������ �ٲ�
		      }
	   }
   }
   
   public void shoot() { // �ܰ����� �Ѿ��� ��� �޼��� ����
	   long now = System.currentTimeMillis(); //���� �ð� ���� now ������ ����
	   
	   
	   if (now - create > delay ) { //���� �ð� ���� ���� �ִ� now���� ���� �ð��� ���� ���� �ִ� create�� ���� ������ ������ ũ�ٸ�
		   Board.aBullet.add(new Bullet(this.x + 45, this.y+68)) ; //�Ѿ� ��ü ������
		   create = now;//��� �����ϰ� �Ѿ��� ������ �ϱ� ����
		   delay = new Random().nextInt(3000);//���� ���� �Ҵ�
	   }
   }
    
   public Rectangle rec() {//�ܰ����� �̹����� �簢�� ���� �ȿ� ����
      Rectangle r=new Rectangle(this.getX(), this.getY(),92, 68);//�簢�� ��ü ����
      return r;//�簢�� ��ȯ
   }
   
}