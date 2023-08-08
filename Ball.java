import java.awt.Graphics2D;
import java.awt.*;
import java.awt.Rectangle;

public class Ball {

	int i = 0; int m = 0; int n = 0;
	int cont_bool1 = 0; int cont_bool2 = 0; int cont_bool3 = 0;
	Boolean bandera1 = true; Boolean bandera2 = true; Boolean bandera3 = true;

	int x_borrar = 0;
	int y_borrar = 0;

	int contador_manzanas = 4;
	boolean bandera_1 = true;
	boolean bandera_2 = true;
	boolean bandera_3 = true;
	boolean bandera_4 = true;

	int x = 0;
	int y = 0;

	//circulo 1
	int x1 = 118;
	int y1 = 135;

	//circulo 2
	int x2 = 118;
	int y2 = 308;

	//circulo 3
	int x3 = 0;
	int y3 = 0;

	// circulo 4
	int x4 = 450;
	int y4 = 0;

	//circulo 5
	int x5 = 118;
	int y5 = 50;

	//circulo 6
	int x6 = 118;
	int y6 = 400;

	//manzana 1
	public static final int mx1 = 10;
	public static final int my1 = 10;

	//manzana 2
	public static final int mx2 = 10;
	public static final int my2 = 450;

	//manzana 3
	public static final int mx3 = 480;
	public static final int my3 = 450;

	//manzana 4
	public static final int mx4 = 480;
	public static final int my4 = 10;
	
	int xa = 1;
	int ya = 1;

	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	private void moveBallrigth() {
		x1 = x1 + 1;
		x2 = x2 + 1;
		x5 = x5 + 1;
		x6 = x6 + 1;
	}

	private void moveBallleft(){
		x1 = x1 - 1;
		x2 = x2 - 1;
		x5 = x5 - 1;
		x6 = x6 - 1;
	}

	private void movediagonalrigth(boolean x){
		if(x == true){
			x3 = x3 + 1;
			y3 = y3 + 1; 

			x4 = x4 + 1;
			y4 = y4 + 1; 
		}else if (x == false){
			x3 = x3 + 1;
			y3 = y3 - 1;

			x4 = x4 + 1;
			y4 = y4 - 1;
		}
	}

	private void movediagonalleft(boolean x){
		if(x == true){
			x3 = x3 - 1;
			y3 = y3 + 1; 

			x4 = x4 - 1;
			y4 = y4 + 1; 
		}else if (x == false){
			x3 = x3 - 1;
			y3 = y3 - 1;

			x4 = x4 - 1;
			y4 = y4 - 1;
		}
	}

	void move() {

		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - 30)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - 30)
			ya = -1;

		x = x + xa;
		y = y + ya;

		if (bandera1 == true){
			moveBallrigth();

			if(bandera2 == true){
				movediagonalrigth(bandera3);
			}else if (bandera2 == false){
				movediagonalleft(bandera3);
			}

		}else if(bandera1 == false){
			moveBallleft();

			if(bandera2 == true){
				movediagonalrigth(bandera3);
			}else if (bandera2 == false){
				movediagonalleft(bandera3);
			}
		}

		i++; m++;

		if (i == 250){
			
			if(cont_bool1%2 == 0){
				bandera1 = false;
			}else{
				bandera1 = true;
			}

			cont_bool1++;
			i = 0;
		}

		if ( m == 35){

			n++;

			if (cont_bool2%2 == 0){
				bandera2 = false;
			}else{
				bandera2 = true;
			}

			cont_bool2++;
			m = 0;

			if(n == 13){
				if (cont_bool3%2 == 0){
					bandera3 = false;
				}else{
					bandera3 = true;
				}

				cont_bool3++;
				n = 0;
			}

		}

		if (collision()){
			game.gameOver();
		}else{
			if(contador_manzanas == 0){
				game.ganar();
			}
		}
	}

	private boolean collision(){

		if ((game.racquet.getBounds().intersects(getBounds1())) == true){
			return game.racquet.getBounds().intersects(getBounds1());
		}else if((game.racquet.getBounds().intersects(circulo1())) == true){
			return game.racquet.getBounds().intersects(circulo1());
		}else if((game.racquet.getBounds().intersects(circulo2())) == true){
			return game.racquet.getBounds().intersects(circulo2());
		}else if((game.racquet.getBounds().intersects(circulo3())) == true){
			return game.racquet.getBounds().intersects(circulo3());
		}else if((game.racquet.getBounds().intersects(circulo4())) == true){
			return game.racquet.getBounds().intersects(circulo4());
		}else if((game.racquet.getBounds().intersects(circulo5())) == true){
			return game.racquet.getBounds().intersects(circulo5());
		}else if((game.racquet.getBounds().intersects(circulo6())) == true){
			return game.racquet.getBounds().intersects(circulo6());
		}else if((game.racquet.getBounds().intersects(rectangulo1())) == true){
			return game.racquet.getBounds().intersects(rectangulo1());
		}else if((game.racquet.getBounds().intersects(rectangulo2())) == true){
			return game.racquet.getBounds().intersects(rectangulo2());
		}else if((game.racquet.getBounds().intersects(rectangulo3())) == true){
			return game.racquet.getBounds().intersects(rectangulo3());
		}else if((game.racquet.getBounds().intersects(rectangulo4())) == true){
			return game.racquet.getBounds().intersects(rectangulo4());
		}else if((game.racquet.getBounds().intersects(rectangulo5())) == true){
			return game.racquet.getBounds().intersects(rectangulo5());
		}else if((game.racquet.getBounds().intersects(rectangulo6())) == true){
			return game.racquet.getBounds().intersects(rectangulo6());
		}else if((game.racquet.getBounds().intersects(rectangulo7())) == true){
			return game.racquet.getBounds().intersects(rectangulo7());
		}else if((game.racquet.getBounds().intersects(rectangulo8())) == true){
			return game.racquet.getBounds().intersects(rectangulo8());
		}else if((game.racquet.getBounds().intersects(rectangulo9())) == true){
			return game.racquet.getBounds().intersects(rectangulo9());
		}else if((game.racquet.getBounds().intersects(rectangulo10())) == true){
			return game.racquet.getBounds().intersects(rectangulo10());
		}else if((game.racquet.getBounds().intersects(manzana1())) == true && bandera_1 == true){
			//manzana 1
			contador_manzanas--;
			bandera_1 = false;
			return false;
		}else if((game.racquet.getBounds().intersects(manzana2())) == true && bandera_2 == true){
			//manzana 2
			contador_manzanas--;
			bandera_2 = false;
			return false;
		}else if((game.racquet.getBounds().intersects(manzana3())) == true && bandera_3 == true){
			//manzana 3
			contador_manzanas--;
			bandera_3 = false;
			return false;
		}else if((game.racquet.getBounds().intersects(manzana4())) == true && bandera_4 == true){
			//manzana 4
			contador_manzanas--;
			bandera_4 = false;
			return false;
		}else{
			return false;
		}
	}

	public Rectangle getBounds1() {
		return new Rectangle(x, y, 30, 30);
	}

	public Rectangle circulo1() {
		return new Rectangle(x1, y1, 10, 10);
	}

	public Rectangle circulo2() {
		return new Rectangle(x2, y2, 10, 10);
	}

	public Rectangle circulo3(){
		return new Rectangle(x3, y3, 10, 10);
	}

	public Rectangle circulo4(){
		return new Rectangle(x4, y4, 10, 10);
	}

	public Rectangle circulo5(){
		return new Rectangle(x5, y5, 10, 10);
	}

	public Rectangle circulo6(){
		return new Rectangle(x6, y6, 10, 10);
	}

	public Rectangle manzana1(){
		return new Rectangle(mx1, my1, 10, 10);
	}

	public Rectangle manzana2(){
		return new Rectangle(mx2, my2, 10, 10);
	}

	public Rectangle manzana3(){
		return new Rectangle(mx3, my3, 10, 10);
	}

	public Rectangle manzana4(){
		return new Rectangle(mx4, my4, 10, 10);
	}

	public Rectangle rectangulo1(){
		return new Rectangle(50, 75, 50, 300 );
	}

	public Rectangle rectangulo2(){
		return new Rectangle(395, 75, 50, 300 );
	}

	public Rectangle rectangulo3(){
		return new Rectangle(100, 195, 30, 50 );
	}

	public Rectangle rectangulo4(){
		return new Rectangle(365, 195, 30, 50 );
	}

	public Rectangle rectangulo5(){
		return new Rectangle(200, 75, 100, 50);
	}

	public Rectangle rectangulo6(){
		return new Rectangle(200, 325, 100, 50 );
	}

	public Rectangle rectangulo7(){
		return new Rectangle(125, 0, 40, 40 );
	}

	public Rectangle rectangulo8(){
		return new Rectangle(330, 0, 40, 40 );
	}

	public Rectangle rectangulo9(){
		return new Rectangle(125, 432, 40, 40 );
	}

	public Rectangle rectangulo10(){
		return new Rectangle(330, 432, 40, 40 );
	}

	public void manzana1(Graphics2D g){
		//manzana 1
		g.setColor( new Color( 0, 0, 255 ) );
		g.fillOval(mx1, my1, 10, 10);
	}

	public void manzana2(Graphics2D g){
		//manzana 2
		g.setColor( new Color( 0, 0, 255 ) );
		g.fillOval(mx2, my2, 10, 10);
	}

	public void manzana3(Graphics2D g){
		//manzana 3
		g.setColor( new Color( 0, 0, 255 ) );
		g.fillOval(mx3, my3, 10, 10);
	}

	public void manzana4(Graphics2D g){
		//manzana 4
		g.setColor( new Color( 0, 0, 255 ) );
		g.fillOval(mx4, my4, 10, 10);
	}

	public void paint(Graphics2D g) {

		g.fillOval(x, y, 30, 30);
		g.fillOval(x1, y1, 10, 10);
		g.fillOval(x2, y2, 10, 10);
		g.fillOval(x3, y3, 10, 10);
		g.fillOval(x4, y4, 10, 10);
		g.fillOval(x5, y5, 10, 10);
		g.fillOval(x6, y6, 10, 10);

		if (bandera_1){
			//manzana 1
			g.setColor( new Color( 255, 128, 0 ) );
			g.fillOval(mx1, my1, 10, 10);
		}

		if (bandera_2){
			//manzana 2
			g.setColor( new Color( 255, 128, 0 ) );
			g.fillOval(mx2, my2, 10, 10);
		}

		if (bandera_3){
			//manzana 3
			g.setColor( new Color( 255, 128, 0 ) );
			g.fillOval(mx3, my3, 10, 10);
		}
		if (bandera_4){
			//manzana 4
			g.setColor( new Color( 255, 128, 0 ) );
			g.fillOval(mx4, my4, 10, 10);
		}

		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 50, 75, 50, 300 );//barra izquierda
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 395, 75, 50, 300 );//barra derecha
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 100, 195, 30, 50 );//complemento barra izquierda
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 365, 195, 30, 50 );//complemento barra derecha
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 200, 75, 100, 50 );// barra horizontal arriba
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 200, 325, 100, 50 );//barra horizontal abajo
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 125, 0, 40, 40 );
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 330, 0, 40, 40 );
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 125, 432, 40, 40 );
		g.setColor( new Color( 255, 0, 0 ) );
		g.fillRect( 330, 432, 40, 40 );
	}
}