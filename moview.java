
/*
ID: grifync1
LANG: JAVA
PROG: moview
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class moview {
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
		//BufferedReader in = new BufferedReader(new FileReader("moview.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moview.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		Pair[] peaks = new Pair[len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			int t = a-b;
			int v = b+a;
			peaks[i] = new Pair(t, v);
		}
		Arrays.sort(peaks);
		int max = -1;
		int ans = 0;
		for(int i=0; i<len; i++) {
			int ce = peaks[i].s;
			if(ce>max) {
				ans++;
				max=ce;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		int f, s;
		public Pair(int a, int b) {
			this.f=a;
			this.s=b;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.f!=o.f) {
				return this.f-o.f;
			}
			else {
				return o.s-this.s;
			}
		}
	}
}
