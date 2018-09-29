import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class factors {

	//	static ArrayList<Integer> primes;
	//	static long min;
	//	static int d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//		System.out.println((long)Math.sqrt(1_000_000_000_000_000l));
		//		System.out.println((long)Math.pow(2, 30));
		int n = sc.nextInt();

		//		primes = new ArrayList<>();

		//		boolean[] isprime = new boolean[(int) Math.sqrt(1_000_000_000_000_000l)+1];
		//		boolean[] checked = new boolean[(int) Math.sqrt(1_000_000_000_000_000l)+1];
		//		primes.add(2);
		//		for (int i = 2; i < isprime.length; i+=2) {
		//			checked[i] = true;
		//		}
		//
		//
		//		for (int i =3; i < isprime.length; i+=2) {
		//			if (!checked[i]) {
		//				isprime[i] = true;
		//				primes.add(i);
		//				for (int j = i; j < isprime.length; j += i) {
		//					checked[j] = true;
		//				}
		//			}
		//		}
		//				System.out.println(primes.get(50) + " " + primes.get(21) + " " + primes.get(2));

		for (int i =0; i < n; i++) {
			int d = sc.nextInt();
			//			System.out.println(used.length);

			//			min = Long.MAX_VALUE;

			//			recurse(1,0,0,1,64,0);
			//			System.out.println(min);
			long res = Long.MAX_VALUE;
			int ff = 0;
			for (int A = 0; A < 60; A++) {
				for (int B = 0; B < 60; B++) {

					long current = 1;

					current *= Math.pow(2, A);
					current *= Math.pow(3, B);
					if ((A+1)*(B+1)==d && current > 0) {
						res = Math.min(res, current);
					}
				}
			}
			//			System.out.println((long)Math.pow(2, 30));
			if (res == Long.MAX_VALUE) {
				res = 0;
			}
			System.out.println(res);
		}
	}

	//	public static void recurse(long sum, int idx, double log, int ps, int ceil, int used) {
	//		//				System.out.println(sum + " " + idx + " " + log + " " + ps);
	//		if (sum > min) return;
	//		if (log >= 15*Math.log(10)+10) return;
	//		if (ps ==d) {
	//			min = Math.min(min, sum);
	//			return;
	//		}
	//		if (idx >= primes.size()) {
	//			return;
	//		}
	//
	//		if (used < 2) 
	//			recurse(sum,idx+1,log,ps,ceil,used);
	//
	//		if (used < 2) {
	//			int get = primes.get(idx);
	//			long running = 1;
	//			for (int i = 1; i < 64 && log + i*Math.log(get) <= 15*Math.log(10)+10 && i <= ceil; i++) {
	//				if (ps * (i+1) > d) break;
	//				if (idx == 0 && i == 0) {
	//					i++;
	//				}
	//				if (i > 0) {
	//					running *= get;
	//				}
	//				recurse(sum*running, idx+1, log + i*Math.log(get), ps * (i+1), Math.min(ceil, i),used+1);
	//			}
	//		}
	//
	//	}

}
/*
5
2
3
4
5
6

1
4

BELOW ARE TOO BIG
31622776
63000000

1
63245552
9223372036854775807

1
100000
9223372036854775807
1
481
9223372036854775807
1
480
7703510787293184
1
475
6499837226778624
1
450
2166612408926208
1
435
1283918464548864
1
425
722204136308736
 */