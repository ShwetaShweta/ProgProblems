import java.awt.Graphics;


public abstract class Shapes {
  protected Point center;
  protected Shapes(Point center){
	  this.center=center;
  }
  public Point getCenter(){
	  return center;
  }
  public abstract Rectangle getBounds();
  public abstract void draw(Graphics g);
}

