 import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyGame extends JFrame { //JFrame 클래스를 상속받음
	
    public MyGame() { //My Game의 생성자
        initUI(); //initUI()메서드 실행
    }
    
    private void initUI() {
        this.add(new Board()); //Board클래스 생성 후 프레임에 추가
        this.setSize(910, 700); //윈도우 창 크기
        this.setTitle("Star"); //윈도우 창 이름
        this.setVisible(true); //창을 화면에 나타나게 함
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) { //main함수

    	int result=JOptionPane.showConfirmDialog(null, "게임을 시작하겠습니까?", "알림창", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	//메시지 질문 창 띄워서 게임을 시작할 것인지 질문함
    	if(result==JOptionPane.YES_OPTION) //YES 라고 대답했을 경우
    	{
    		MyGame ex = new MyGame(); //MyGame 클래스의 객체 생성(게임 시작)
    	}
    	else { //NO 라고 대답했을 경우
    		System.exit(0); //프로그램 종료(게임 종료)
    	}	  
    }
} 