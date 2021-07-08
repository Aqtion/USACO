
/*
ID: grifync1
LANG: JAVA
PROG: restaurantcustomers
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class restaurantcustomers {
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
		//BufferedReader in = new BufferedReader(new FileReader("restaurantcustomers.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("restaurantcustomers.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		Pair[] times = new Pair[2*len];
		int ind = 0;
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long f = conv(st.nextToken());
			int e = conv(st.nextToken());
			times[ind++]=new Pair(f, true);
			times[ind++]=new Pair(e, false);
		}
		Arrays.sort(times);
		int ans = 0;
		int cnt = 0;
		for(int i=0; i<2*len; i++) {
			if(times[i].l) {
				cnt++;
			}
			else {
				cnt--;
				ans=max(ans, cnt+1);
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		long a; boolean l;
		public Pair(long x, boolean y) {
			this.a=x;
			this.l=y;
		}
		@Override
		public int compareTo(Pair o) {
			return (int) (this.a-o.a);
		}
	}
}
