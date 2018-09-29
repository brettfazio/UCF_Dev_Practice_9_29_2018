import java.util.Arrays;
import java.util.Scanner;

public class fowl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i =0 ; i< cases; i++) {

			int[] a = new int[3];
			a[0] = sc.nextInt();
			a[1] =sc.nextInt();
			a[2] = sc.nextInt();
			Arrays.sort(a);
			System.out.print("Target #" +(i+1)+": ");
			if (a[0]*a[0] + a[1]*a[1] == a[2]*a[2]) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}

}
