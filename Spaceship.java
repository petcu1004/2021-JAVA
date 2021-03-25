import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Spaceship extends Sprite { //Sprite�κ��� ����� ����
    private int dx; //���ּ� x��ǥ�� ������ ����
    private int dy; //���ּ� y��ǥ�� ������ ����
   
    ArrayList<Missile> m = new ArrayList<>(); //Missile Ÿ���� ArrayList ����

    public Spaceship(int x, int y) { //Spaceship Ŭ������ ������
    	super(x, y); //�θ� Ŭ���� �����ڸ� ȣ���ϴ� ��
        loadImage("ship.png"); //ship.png ������ ������ �̹��� �ε��Ŵ
        getImageDimensions();
    }

    public void move() { //���ּ� ������ ����
        x += dx; //x��ǥ�� ������ �� ����
        y += dy; //y��ǥ�� ������ �� ����
    }

    public ArrayList<Missile> getMissile() { //�̻��� ArrayList ��ȯ
        return m;
    }
    
    public void fire() { //�����̽��ٸ� ������
    	m.add(new Missile(x, y)); //���ο� ��ü ����
    	
    }

    public void keyPressed(KeyEvent e) { //Ű�� ���� ���(�޼ҵ� ������) 
        int key = e.getKeyCode(); //Ű �ڵ� ������ key ������ �Ҵ�
        if (key == KeyEvent.VK_SPACE) { //�����̽��ٸ� ���� ���
        	fire(); //fire �޼��� ����
        }
        if (key == KeyEvent.VK_LEFT) { //���� ����Ű�� ���� ���
            dx = -2; //���� �������� ������
        }
        if (key == KeyEvent.VK_RIGHT) { //������ ����Ű�� ���� ���
            dx = 2; //������ �������� ������
        }
        if (key == KeyEvent.VK_UP) { //�� ����Ű�� ���� ���
            dy = -2; //���� �������� ������
        }
        if (key == KeyEvent.VK_DOWN) { //�Ʒ� ����Ű�� ���� ���
            dy = 2; //�Ʒ��� �������� ������
        }
    }

    public void keyReleased(KeyEvent e) { //Ű�� ������ ���� ���
        int key = e.getKeyCode(); //Ű �ڵ� ������ key ������ �Ҵ�
        if (key == KeyEvent.VK_LEFT) { //���� ����Ű�� ������ ���� ���
            dx = 0; //����
        }
        if (key == KeyEvent.VK_RIGHT) {//������ ����Ű�� ������ ���� ���
            dx = 0; //����
        }
        if (key == KeyEvent.VK_UP) {//�� ����Ű�� ������ ���� ���
            dy = 0; //����
        }
        if (key == KeyEvent.VK_DOWN) {//�Ʒ� ����Ű�� ������ ���� ���
            dy = 0; //����
        }
    }
}
