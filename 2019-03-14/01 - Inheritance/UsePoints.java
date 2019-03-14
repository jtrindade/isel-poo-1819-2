public class UsePoints {
	
	public static void main(String[] args) {
		//example1();
		example2();
	}

	private static void example1() {
		Point p = createPoint();
		
		System.out.println("magnitude: " + p.magnitude());
	}

	private static Point createPoint() {
		return new Point3D(3, 4, 5);
	}
	
	private static void example2() {
		Point[] points = new Point[5];
		
		points[0] = new Point(3, 4);
		points[1] = new Point3D(3, 4, 5);
		points[2] = new Point(6, 7);
		points[3] = new Point(8, 9);
		points[4] = new Point3D(10, 11, 12);
		
		for (Point p : points) {
			System.out.println("magnitude: " + p.magnitude());
			//System.out.println(p);
		}
	}
}