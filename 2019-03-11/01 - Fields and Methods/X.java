public class X {

	private int a;
	private int b;

	public X(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int sum() {
		return a + b ;
	}

	public static int sum(X _this) {
		return _this.a + _this.b ;
	}

	public static void main(String[] args) {
		
		X obj1 = new X(3, 4);
		X obj2 = new X(7, 8);
		
		int res1 = obj1.sum();
		int res2 = obj2.sum();
		
		int _res1 = X.sum(obj1);
		int _res2 = X.sum(obj2);
		
		System.out.println(" res1 = " +  res1);
		System.out.println(" res2 = " +  res2);
		
		System.out.println("_res1 = " + _res1);
		System.out.println("_res2 = " + _res2);
	}
}
