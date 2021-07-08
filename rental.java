
/*
ID: grifync1
LANG: JAVA
PROG: rental
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class rental {
	public static int conv(String s) {
		return Integer.parseInt(s);
	}

	public static int max(int a, int b) {
		return Math.max(a, b);
	}

	public static int min(int a, int b) {
		return Math.min(a, b);
	}

	public static void print(int num) {
		System.out.println(num);
	}

	public static void prints(String s) {
		System.out.println(s);
	}

	public static void printa(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				System.out.print(a[i]);
			} else {
				System.out.print(" " + a[i]);
			}
		}
	}

	public static int[] sort(int[] nums) {
		Arrays.sort(nums);
		return nums;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("rental.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int m = conv(st.nextToken());
		int r = conv(st.nextToken());
		int[] cows = new int[n];
		Pair[] shops = new Pair[m];
		for(int i=0; i<n; i++) {
			cows[i]=conv(in.readLine());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			shops[i] = new Pair(a, b);
		}
		oPair[] rents = new oPair[r];
		for(int i=0; i<r; i++) {
			int a = conv(in.readLine());
			rents[i] = new oPair(a, false);
		}
		Arrays.sort(shops);
		Arrays.sort(cows);
		Arrays.sort(rents);
		long[] pfr = new long[n];
		long[] pfs = new long[n];
		long cost = 0;
		int i = n-1;
		int it = 0;
		long tcost = 0;
		while(i>=0) {
			int cg = cows[i];
			
			while(it<m && cg>0) {
				long gall = min(cg, shops[it].gals);
				tcost+=(gall)*shops[it].cost;
				if(i+1==n) {
					pfs[0]=tcost;
				}
				else {
					pfs[n-i-1]=tcost;
				}
				if(cg<shops[it].gals) {
					cg=0;
					shops[it].gals-=gall;
				}
				else {
					shops[it].gals=0;
					cg-=gall;
					it++;
				}
			}
			
			i--;
		}
		i = n-1;
		it = 0;
		while(i>=0) {
			if(i+1==n) {
				pfr[n-1]=rents[it].rc;
			}
			else if(it>=r) {
				pfr[i]=pfr[i+1];
			}
			else {
				pfr[i]=pfr[i+1]+rents[it].rc;
			}
			it++;
			i--;
			
		}
		int fp = 0;
		int sp = 1;
		while(sp<n) {
			cost = Math.max(cost, pfs[fp]+pfr[sp]);
			fp++;
			sp++;
		}
		cost = Math.max(cost, pfr[0]);
		cost = Math.max(cost, pfs[n-1]);
		out.println(cost);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair> {
		int gals, cost;
		public Pair(int a, int b) {
			this.gals = a;
			this.cost = b;
		}
		@Override
		public int compareTo(Pair o) {
			return o.cost-this.cost;
		}
	}
	static class oPair implements Comparable<oPair> {
		int rc;
		boolean used;
		public oPair(int a, boolean b) {
			this.rc = a;
			this.used=b;
		}
		@Override
		public int compareTo(oPair o) {
			return o.rc-this.rc;
		}
		
	}
}
