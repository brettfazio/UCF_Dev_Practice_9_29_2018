import java.util.Scanner;

public class bird {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int oo = 1; oo <= cases; oo++) {
			int r = sc.nextInt();
			int nodes = sc.nextInt();
			
			
			int[] x = new int[nodes];
			int[] y = new int[nodes];
			
			for (int i =0; i < nodes; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			
			double bx = 0;
			double by = 0;
			boolean out = false;
			for (int i =0; i < nodes; i++) {
				int next = i + 1;
				next %= nodes;
				
				Vector se = new Vector(x[i],y[i],x[next],y[next]);
				Vector sp = new Vector(x[i],y[i],bx,by);
//				System.out.println(angledot(sp.c,sp.d,se.c,se.d));
				double d = mag(sp.c,sp.d) * Math.sin(angledot(sp.c,sp.d,se.c,se.d));
//				System.out.println(d);
				if (r >= d) {
					out = true;
				}
			}
			
			System.out.printf("Yard #%d: %s%n", oo, !out ? "Fly away!" : "Better not risk it.");
			
		}
	}
	
	static double angledot(double a, double b, double c, double d) {
		return Math.acos((a*c+b*d)/(mag(a,b)*mag(c,d)));
	}
	static double mag(double a, double b) {
		return Math.sqrt(a*a+b*b);
	}
	static double cross(double mag1, double mag2, double theta) {
		return mag1 * mag2 * Math.sin(theta);
	}

}

class Vector {
	double a,b;
	double c,d;
	double beta;
	
	public Vector(double x1, double y1, double x2, double y2) {
		a = x1;
		b = y1;
		c = x2-x1;
		d = y2-y1;
	}
	
	public Pair intersection(Vector o) {
		Pair ret = new Pair(0,0);
		//x
		double xconst = o.a - a;
		double xmybeta = c;
		double xobeta = -1*o.c;
		//y
		double yconst = o.b - b;
		double ymybeta = d;
		double yobeta = -1*o.d;

		double top = xconst * yobeta - yconst * xobeta;
		double bot = xmybeta * yobeta - xobeta * ymybeta;
		double div = top / bot;

		ret = new Pair(a + (div*c), b + (div*d));
		
		return ret;
	}
	
	public String toString() {
		return "Vector (a b c d) = " + a + " " + b + " " + c + " " + d;
	}
}

class Pair {
	double x, y;
	
	public Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}
}