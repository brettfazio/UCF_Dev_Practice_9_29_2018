import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class relatives {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = 1;
		
		while (true) {
			int nodes = sc.nextInt();
			int edges = sc.nextInt();
			
			int[][] dp = new int[nodes][nodes];
			
			for (int i= 0; i < nodes; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE/2);
			}
			for (int i =0 ; i < nodes; i++) {
				dp[i][i] = 0;
			}
			
			if (nodes == 0 && edges ==0 ) {
				break;
			}
			
			TreeMap<String,Integer>mapper = new TreeMap<>();
			
			for (int i =0 ; i < edges; i++) {
				String a = sc.next();
				String b = sc.next();
				
				int ia =0, ib =0 ;
				
				if (mapper.containsKey(a)) {
					ia = mapper.get(a);
				}else {
					mapper.put(a, mapper.size());
					ia = mapper.get(a);
				}
				
				if (mapper.containsKey(b)) {
					ib = mapper.get(b);
				}else {
					mapper.put(b, mapper.size());
					ib = mapper.get(b);
				}
				
				dp[ia][ib] = dp[ib][ia] = 1;
			}
			
			for (int k =0; k < nodes; k++) {
				for (int i =0; i < nodes; i++) {
					for (int j =0; j < nodes; j++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
					}
				}
			}
			
			int max = 0;
			
			for (int i =0; i < nodes; i++) {
				for (int j =0 ; j < nodes; j++) {
					max = Math.max(max, dp[i][j]);
				}
			}
			System.out.print("Network " + (cases)+": ");
			System.out.println(max >= 1073741823 ? "DISCONNECTED" : max);
			System.out.println();
			
			cases++;
		}
	}

}

/*

4 4
A K U C U K K C
4 2
A C U K
6 5
B Co A K U C U K K C
0 0

*/
