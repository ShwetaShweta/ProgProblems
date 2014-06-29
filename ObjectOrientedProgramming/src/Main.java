import java.awt.Graphics;
import java.util.ArrayList;


public class Main {
	static void  paintShapes(Graphics g,ArrayList<Shapes> shapes){
		for(Shapes shape:shapes){
			shape.draw(g);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point center = new Point(0,0);
		Rectangle rectangle = new Rectangle(center , 20 , 10);
		Ellipse ellipse  = new Ellipse(center , 4 ,16);
		ArrayList<Shapes> shapes = new ArrayList<Shapes>();
		shapes.add(rectangle);
		shapes.add(ellipse);
		Graphics g = rectangle.getGraphics()
		Main.paintShapes(g, shapes);
		


	}

}
