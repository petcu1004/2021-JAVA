import java.awt.EventQueue;
import javax.swing.JFrame;

public class MyGame extends JFrame { 

    public MyGame() {
        initUI();
    }
    
    private void initUI() {
        add(new Board()); //Board클래스 생성 후 프레임에 추가
        setSize(1000, 700); //윈도우 창 크기
        setTitle("Star"); //윈도우 창 이름
        setVisible(true); //창을 화면에 나타나게 함
    }

    public static void main(String[] args) {
            	MyGame ex = new MyGame(); //객체 생성
    }
}