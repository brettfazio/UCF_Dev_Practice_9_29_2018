import java.util.Scanner;

public class circles {

	static double PI = 3.1415926535898;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int drops = sc.nextInt();

			double[]x = new double[drops];
			double[]y = new double[drops];
			double[]r= new double[drops];

			for (int j =0; j < drops; j++) {
				x[j] = sc.nextDouble();
				y[j] = sc.nextDouble();
				r[j] = sc.nextDouble();
			}

			double sum = 0;

			for (int j =0; j < drops; j++) {
				sum += PI * r[j]*r[j];
			}

			for (int j =0 ; j < drops-1; j++) {
				if (intersect(x[j],y[j],r[j],x[j+1],y[j+1],r[j+1])) {
					sum -= areaOfIntersection(x[j], y[j], r[j], x[j+1], y[j+1], r[j+1]);
				}
			}

			System.out.printf("Set #%d: %.2f%n%n", i+1, sum);
		}


	}

	static boolean intersect(double x0, double y0, double r0, double x1, double y1, double r1) {

		double dist = Math.sqrt(Math.pow(x0-x1, 2)+Math.pow(y0-y1, 2));
		
		double sum = r0+r1;
		
		if (sum >= dist) {
			return true;
		}
		
		return false;
	}

	static double areaOfIntersection(double x0, double y0, double r0, double x1, double y1, double r1) {
		double rr0 = r0 * r0,  rr1 = r1 * r1;
		double d = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));

		if(d > r1 + r0)  return 0;
		if(d <= Math.abs(r0 - r1) && r0 >= r1)  return Math.PI * rr1;
		if(d <= Math.abs(r0 - r1) && r0 < r1)  return Math.PI * rr0;

		double phi = 2 * Math.acos((rr0 + (d * d) - rr1) / (2 * r0 * d));
		double theta = 2 * Math.acos((rr1 + (d * d) - rr0) / (2 * r1 * d));
		return (rr1 * (theta - Math.sin(theta)) + rr0 * (phi - Math.sin(phi))) / 2;
	}

}
