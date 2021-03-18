import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Spaceship extends Sprite { //Sprite로부터 상속을 받음
    private int dx; //우주선 x좌표의 움직임 결정
    private int dy; //우주선 y좌표의 움직임 결정
   
    ArrayList<Missile> m = new ArrayList<>(); //Missile 타입인 ArrayList 선언

    public Spaceship(int x, int y) { //Spaceship 클래스의 생성자
    	super(x, y); //부모 클래스 생성자를 호출하는 것
        loadImage("ship.png"); //ship.png 파일을 가져와 이미지 로드시킴
        getImageDimensions();
    }

    public void move() { //우주선 움직임 구현
        x += dx; //x좌표로 움직일 수 있음
        y += dy; //y좌표로 움직일 수 있음
    }

    public ArrayList<Missile> getMissile() { //미사일 ArrayList 반환
        return m;
    }
    
    public void fire() { //스페이스바를 누르면
    	m.add(new Missile(x, y)); //새로운 객체 생성
    	
    }

    public void keyPressed(KeyEvent e) { //키를 누른 경우(메소드 재정의) 
        int key = e.getKeyCode(); //키 코드 가져와 key 변수에 할당
        if (key == KeyEvent.VK_SPACE) { //스페이스바를 누른 경우
        	fire(); //fire 메서드 실행
        }
        if (key == KeyEvent.VK_LEFT) { //왼쪽 방향키를 누를 경우
            dx = -2; //왼쪽 방향으로 움직임
        }
        if (key == KeyEvent.VK_RIGHT) { //오른쪽 방향키를 누를 경우
            dx = 2; //오른쪽 방향으로 움직임
        }
        if (key == KeyEvent.VK_UP) { //윗 방향키를 누를 경우
            dy = -2; //위쪽 방향으로 움직임
        }
        if (key == KeyEvent.VK_DOWN) { //아래 방향키를 누를 경우
            dy = 2; //아래쪽 방향으로 움직임
        }
    }

    public void keyReleased(KeyEvent e) { //키를 누르지 않은 경우
        int key = e.getKeyCode(); //키 코드 가져와 key 변수에 할당
        if (key == KeyEvent.VK_LEFT) { //왼쪽 방향키를 누르지 않은 경우
            dx = 0; //정지
        }
        if (key == KeyEvent.VK_RIGHT) {//오른쪽 방향키를 누르지 않은 경우
            dx = 0; //정지
        }
        if (key == KeyEvent.VK_UP) {//윗 방향키를 누르지 않은 경우
            dy = 0; //정지
        }
        if (key == KeyEvent.VK_DOWN) {//아래 방향키를 누르지 않은 경우
            dy = 0; //정지
        }
    }
}
