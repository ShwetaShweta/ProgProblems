import java.awt.Graphics;


public class Ellipse extends Shapes {
	private int a;
	private int b;
	public Ellipse(Point center , int a ,int b){
		super(center);
		this.a = a;
		this.b = b;
	}
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(center, a*2 , b*2);
	}
	public int getSemiMajorAxis(){
		return a;
	}
	public int getSemiMinorAxis(){
		return b;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		this.draw(g);
	}

}
