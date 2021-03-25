import java.awt.EventQueue;
import javax.swing.JFrame;

public class MyGame extends JFrame { //JFrame 클래스를 상속받음

    public MyGame() { //My Game의 생성자
        initUI(); //initUI()메서드 실행
    }
    
    private void initUI() {
        add(new Board()); //Board클래스 생성 후 프레임에 추가
        setSize(1000, 700); //윈도우 창 크기
        setTitle("Star"); //윈도우 창 이름
        setVisible(true); //창을 화면에 나타나게 함
    }

    public static void main(String[] args) { //main함수
            	MyGame ex = new MyGame(); //MyGame 클래스의 객체 생성
    }
}