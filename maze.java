import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class maze {

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		
		for (int i = 0; i < c; i++) {
			int d = sc.nextInt();
			int a = sc.nextInt();
			
			char[][] map = new char[d][a];
			
			for (int j =0 ; j < d; j++) {
				map[j] = sc.next().toCharArray();
			}
			
			ArrayDeque<Integer> dqd = new ArrayDeque<Integer>();
			ArrayDeque<Integer> dqa = new ArrayDeque<>();
			
			outer: for (int ddd = 0; ddd < d; ddd++) {
				for (int aaa =0 ; aaa < a; aaa++) {
					if (map[ddd][aaa] == 'S') {
						dqd.add(ddd);
						dqa.add(aaa);
						break outer;
					}
				}
			}
			
			boolean out = false;
			int ss = -1;
			int[][] steps = new int[d][a];
			for (int h = 0; h < d; h++) {
				Arrays.fill(steps[h],Integer.MAX_VALUE/2);
			}
			steps[dqd.peekFirst()][dqa.peekFirst()] = 0;
			oo: while (dqd.isEmpty() == false) {
				
				int cd = dqd.pollFirst();
				int ca = dqa.pollFirst();
				
				for (int t =0; t < 4; t++) {
					int nd = cd+dx[t];
					int na = ca+dy[t];
					
					if (nd < 0 || nd >= d || na < 0 || na >= a) {

						continue;
					}
					if (steps[nd][na] == Integer.MAX_VALUE/2 && map[nd][na]== '~') {
						out = true;
						ss = steps[cd][ca]+1;
						break oo;
					} 
					if (steps[nd][na] == Integer.MAX_VALUE/2 && map[nd][na]== '-') {
						dqd.add(nd);
						dqa.add(na);
						steps[nd][na] = steps[cd][ca]+1;
					} 
					
				}
			}
			
			System.out.println(ss == -1 ? -1 : ss);
		}
	}

}
