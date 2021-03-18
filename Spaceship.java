import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Spaceship extends Sprite { //Sprite�κ��� ����� ����
    private int dx;
    private int dy;

    ArrayList<Missile> m=new ArrayList();
    
    public Spaceship(int x, int y) {
    	super(x, y); //�θ� Ŭ���� �����ڸ� ȣ���ϴ� ��
        loadImage("s.png"); 
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public ArrayList<Missile> getMissile() {
        return m;
    }

    public void fire() { 
        m.add(new Missile(x, y));
    }

    public void keyPressed(KeyEvent e) { //�޼ҵ� ������ 
        int key = e.getKeyCode(); //Ű �ڵ带 �̾ƿ�..?
        if (key == KeyEvent.VK_SPACE) {
        	fire();
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
