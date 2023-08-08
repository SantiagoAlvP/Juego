
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.*;

public class Racquet {
	int x = 230;
	int y = 230;
	int xa = 0;
	int ya = 0;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private Game game;

	public Racquet(Game game) {
		this.game= game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()-20){
			x = x + xa;
			if (y + ya > 0 && y + ya < game.getHeight()-20){
				y = y + ya;
			}
		}else if (y + ya > 0 && y + ya < game.getHeight()-20){
			y = y + ya;
			if (x + xa > 0 && x + xa < game.getWidth()-20)
			x = x + xa;
		}
	}

	public void paint(Graphics2D g) {

		g.setColor( new Color( 100, 200, 10 ) );
		g.fillRect (x, y, WIDTH, HEIGHT);

	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
		ya = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			ya = -1;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = 1;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}