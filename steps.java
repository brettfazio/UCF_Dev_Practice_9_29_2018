import java.util.Scanner;

public class steps {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		int locs = sc.nextInt();
		
		long[][] adj = new long[locs][locs];
		
		for (int d= 0; d < locs; d++) {
			for (int a= 0; a < locs; a++) {
				adj[d][a] = sc.nextLong();
			}
		}
		
		int pathes = sc.nextInt();
		
		for (int i =0; i < pathes; i++) {
			char[] in = sc.next().toCharArray();
			
			long sum = 0;
			
			for (int j =0; j < in.length-1; j++) {
				sum += adj[in[j]-'A'][in[j+1]-'A'];
			}
			
			System.out.println(sum);
		}
	}

}
