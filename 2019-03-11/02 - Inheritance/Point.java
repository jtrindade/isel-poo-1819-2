public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public double magnitude() { return Math.sqrt(x*x + y*y); }
	
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
}
