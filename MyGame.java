import java.awt.EventQueue;
import javax.swing.JFrame;

public class MyGame extends JFrame { 

    public MyGame() {
        initUI();
    }
    
    private void initUI() {
        add(new Board()); //BoardŬ���� ���� �� �����ӿ� �߰�
        setSize(1000, 700); //������ â ũ��
        setTitle("Star"); //������ â �̸�
        setVisible(true); //â�� ȭ�鿡 ��Ÿ���� ��
    }

    public static void main(String[] args) {
            	MyGame ex = new MyGame(); //��ü ����
    }
}