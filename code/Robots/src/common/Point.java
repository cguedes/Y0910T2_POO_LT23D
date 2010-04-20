package common;

/**
 * @author  cguedes
 */
public class Point {

	public double x = 0;
	public double y = 0;

	public Point()             		 { }
	public Point(double x, double y) { this.x = x; this.y = y; }
	public Point(Point point) 		 { this(point.x, point.y); }

	// Direcções (delta)
	/**
	 * @uml.property  name="lEFT"
	 * @uml.associationEnd  
	 */
	public final static Point LEFT 	  = new Point(-1,  0); 
	/**
	 * @uml.property  name="rIGHT"
	 * @uml.associationEnd  
	 */
	public final static Point RIGHT	  = new Point( 1,  0); 
	/**
	 * @uml.property  name="uP"
	 * @uml.associationEnd  
	 */
	public final static Point UP 	  = new Point( 0, -1); 
	/**
	 * @uml.property  name="dOWN"
	 * @uml.associationEnd  
	 */
	public final static Point DOWN 	  = new Point( 0,  1);
	/**
	 * @uml.property  name="sTOPED"
	 * @uml.associationEnd  
	 */
	public static final Point STOPED  = new Point( 0,  0);

	public Point moveTo(Point newPos) {
		this.x = newPos.x;
		this.y = newPos.y;
		return this;
	} 
	
	public Point translate(Point delta) {
		this.x += delta.x;
		this.y += delta.y;
		return this;
	} 

	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(other instanceof Point == false) return false;
		
		Point otherPoint = (Point)other;
		return this.x == otherPoint.x && this.y == otherPoint.y;
	}

	public static Point subtract(Point first, Point second) {
		Point p = new Point();
		p.x = first.x - second.x;
		p.y = first.y - second.y;
		return p;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s)", this.x, this.y);
	}
}
