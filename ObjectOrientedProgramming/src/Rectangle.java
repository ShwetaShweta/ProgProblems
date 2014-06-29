import java.awt.Graphics;


public class Rectangle extends Shapes {
	private int h;
	private int w;
	public Rectangle(Point center, int h , int w){
		super(center);
		this.h = h;
		this.w = w;
	}
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return this;
	}
	public int getHeight(){
		return h;
	}
	public int getWidth(){
		return w;
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.draw3DRect(center.getX(), center.getY(), w, h,false);
	}

}
