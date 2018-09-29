import java.util.Scanner;
import java.util.TreeSet;

public class minion {

	static boolean[][] adj;
	static boolean reached;
	static boolean[] hit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			int unable = sc.nextInt();
//			TreeMap<String,Integer> mapper = new TreeMap<>();
			TreeSet<String> u = new TreeSet<String>();
//			String[] un = new String[unable];
			
			for (int j =0 ; j < unable; j++) {
//				un[j] = sc.next();
//				mapper.put(un[j], mapper.size());
				String in = sc.next();
				u.add(in);
			}
			
			int locs = sc.nextInt();
			int routes = sc.nextInt();
			
			int start = 0;
			int end = locs-1;
			
			hit = new boolean[locs];
			reached = false;
			hit[start] = true;
			adj = new boolean[locs][locs];
			
			for (int j =0 ; j < routes; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				String q = sc.next();
				
				if (!u.contains(q)) {
					adj[a][b] = adj[b][a] = true;
				}
			}
			
			brett(0);
			
			if (reached) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
	
	public static void brett(int pos) {
		if (pos == adj.length-1) {
			reached = true;
			return;
		}
		if (reached) return;
		
		for (int j = 0; j < adj.length; j++) {
			if (adj[j][pos] && !hit[j]) {
				hit[j] = true;
				brett(j);
			}
		}
	}

}
