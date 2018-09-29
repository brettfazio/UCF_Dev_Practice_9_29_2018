import java.util.Scanner;

public class happy {

	static int[] items, perm;
	static boolean[] used;
	
	static boolean found;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i =0 ; i< n; i++) {
			int k = sc.nextInt();
			
			found = false;
			items = new int[k];
			perm = new int[k];
			used = new boolean[k];
			
			for (int j =0; j < k; j++) {
				items[j] = sc.nextInt();
			}
			
			perm(0);
			System.out.print("Set " + (i+1) +" is a ");
			if (found) {
				System.out.println("Happy Set =)");
			}else {
				System.out.println("Sad Set =(");
			}
		}
	}
	
	public static void perm(int pos) {
		if (found) return;
		int j =0;
		if (pos >= used.length) {
			
			boolean good = true;
			int operation = 1;
			int running = perm[0];
			for (int i =1; i < used.length; i++) {
				
				if (operation % 4 == 0) {
					//div
					if (perm[i] == 0) {
						good = false;
						return;
					}
					if (running % perm[i] != 0) {
						good = false;
						return;
					}
					running /= perm[i];
				}else if (operation % 4 == 3) {
					// mult
					running *= perm[i];
				}else if (operation % 4 == 2) {
					// minus
					running -= perm[i];
				}else {
					running += perm[i];
				}
				
				operation++;
			}
			
			if (good) {
				found = true;
				return;
			}
			
		}else {
			for (j = 0; j < used.length; j++) {
				if (!used[j]) {
					used[j] = true;
					perm[pos] = items[j];
					perm(pos+1);
					used[j] = false;
				}
			}
		}
	}

}
