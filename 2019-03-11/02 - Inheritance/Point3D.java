public class Point3D extends Point {
	
	private int z;
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public int getZ() { return z; }
	
	public double magnitude() { 
		// return Math.sqrt(x*x + y*y + z*z);
		double xymag = super.magnitude();
		return Math.sqrt(xymag*xymag + z*z);
	}
	
	public void translate(int dx, int dy, int dz) {
		super.translate(dx, dy);
		z += dz;
	}
}