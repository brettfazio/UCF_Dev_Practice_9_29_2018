import java.util.Scanner;
import java.util.TreeMap;

public class family {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1;
		while (true) {
			int n = sc.nextInt();
			
			if (n == 0) break;
			
			DSU d = new DSU(3*n);
			
			TreeMap<String,Integer> mapper = new TreeMap<>();
			
			for (int i = 0; i < n; i++) {
				String a = sc.next();
				String b = sc.next();
				String c= sc.next();
				
				int ia = 0, ib = 0, ic = 0;
				
				if (mapper.containsKey(a)) {
					ia = mapper.get(a);
				}else {
					ia = mapper.size();
					mapper.put(a, ia);
				}
				
				if (mapper.containsKey(b)) {
					ib = mapper.get(b);
				}else {
					ib = mapper.size();
					mapper.put(b, ib);
				}
				
				if (mapper.containsKey(c)) {
					ic = mapper.get(c);
				}else {
					ic = mapper.size();
					mapper.put(c, ic);
				}
//				System.out.println(ia + " " + ib + " " + ic);
				
				d.union(ia, ic);
				d.union(ib, ic);
//				d.union(ia, ib);
			}
			
			String g = sc.next();
			String h = sc.next();
			System.out.print("Family #" + (cases)+": ");
			if (mapper.containsKey(g)==false) {
				System.out.println("Not related.");
			}else if (mapper.containsKey(h)==false) {
				System.out.println("Not related.");
			}else {
				if (d.findParent(mapper.get(g))==d.findParent(mapper.get(h))) {
					System.out.println("Related.");
				}else {
					System.out.println("Not related.");
				}
			}
			
			cases++;
		}
	}

}

/*
2
Barbara Bill Ted
Nancy Ted John
John Barbara
3
Lois Frank Jack
Florence Bill Fred
Annie Fred James
James Jack
1
John Susan Billy
John Susan
2
Karen Roger Christopher
Karen Roger Michael
Christopher Michael
0


2
Barbara Bill Ted
Nancy Ted John
John Barbara
2
Barbara Bill Ted
Nancy Ted John
Barbara Bill
0

 */

class DSU {
	int[] root;
	int[] height;
	int n;

	DSU(int n) {
		this.n = n;
		root = new int[n];
		height = new int[n];
		for(int i = 0; i < n; i++) 
			root[i] = i;
	}

	int findParent(int idx) {
		if(root[idx] != idx) return findParent(root[idx]);
		return idx;
	}

	boolean union(int x, int y) {
		int parX = findParent(x);
		int parY = findParent(y);
		
		if(parX == parY) return false;
		root[parY] = parX;
		
		return true;
	}
}