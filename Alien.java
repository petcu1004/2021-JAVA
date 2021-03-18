import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.*;
import java.awt.Rectangle;

public class Alien extends Sprite{

	private int ALIEN_SPEED=7;
	private int ALIEN_SPEED1=5;
	int dx=2, dy=2;
	private final int move = 10;

	public Alien(int x, int y) {
		super(x, y);
		loadImage("a.png");

	}

	public void move_even() {

		x+=ALIEN_SPEED;
		//y+=ALIEN_SPEED-2;

		if(x<=0||x>=800) {
			ALIEN_SPEED = -ALIEN_SPEED;
		}
	}
		
	public void move_odd() {
		y=70;
		x+=ALIEN_SPEED1;
		if(x<=0||x>=800) {
			ALIEN_SPEED1 = -ALIEN_SPEED1;
		}
	}
	
	public Rectangle rec() {
		Rectangle r=new Rectangle(this.getX(), this.getY(),100, 37);
		return r;
	}
	
}
