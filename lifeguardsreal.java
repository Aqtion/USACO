
/*
ID: grifync1
LANG: JAVA
PROG: lifeguardsreal
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class lifeguardsreal {
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
		BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		Pair[] intervals = new Pair[len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long f = conv(st.nextToken());
			long e = conv(st.nextToken());
			intervals[i]=new Pair(f,e);
		}
		Arrays.sort(intervals);
		long le = 0;
		long ri = 0;
		long tt = 0;
		for(int i=0; i<len; i++) {
			if(intervals[i].r>ri) {
				le = Math.max(intervals[i].l, ri);
				tt+=(intervals[i].r-le);
				ri = intervals[i].r;
			}
		}
		long min = Long.MAX_VALUE;
		long right = 0;
		for(int i=0; i<len; i++) {
			if(i==len-1) {
				min = Math.min(min, intervals[i].r-Math.max(intervals[i].l, right));
			}
			else {
				long leftmax = Math.max(right, intervals[i].l);
				long rightmin = Math.min(intervals[i].r, intervals[i+1].l);
				min = Math.min(min, rightmin-leftmax);
				right = Math.max(right, intervals[i].r);
			}
		}
		min = Math.max(min, 0);
		out.println(tt-min);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		long l;
		long r;
		public Pair(long a, long b) {
			this.l=a;
			this.r=b;
		}
		@Override
		public int compareTo(Pair o) {
			return (int) (this.l-o.l);
		}
		
	}
}
