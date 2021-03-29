 import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyGame extends JFrame { //JFrame Ŭ������ ��ӹ���
	
    public MyGame() { //My Game�� ������
        initUI(); //initUI()�޼��� ����
    }
    
    private void initUI() {
        this.add(new Board()); //BoardŬ���� ���� �� �����ӿ� �߰�
        this.setSize(910, 700); //������ â ũ��
        this.setTitle("Star"); //������ â �̸�
        this.setVisible(true); //â�� ȭ�鿡 ��Ÿ���� ��
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) { //main�Լ�

    	int result=JOptionPane.showConfirmDialog(null, "������ �����ϰڽ��ϱ�?", "�˸�â", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	//�޽��� ���� â ����� ������ ������ ������ ������
    	if(result==JOptionPane.YES_OPTION) //YES ��� ������� ���
    	{
    		MyGame ex = new MyGame(); //MyGame Ŭ������ ��ü ����(���� ����)
    	}
    	else { //NO ��� ������� ���
    		System.exit(0); //���α׷� ����(���� ����)
    	}	  
    }
} 