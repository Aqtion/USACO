
/*
ID: grifync1
LANG: JAVA
PROG: tasksanddeadlines
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class tasksanddeadlines {
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
		//BufferedReader in = new BufferedReader(new FileReader("tasksanddeadlines.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tasksanddeadlines.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		Pair[] pairs = new Pair[len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			pairs[i] = new Pair(a, b);
		}
		Arrays.sort(pairs);
		long ce = 0;
		long ans = 0;
		for(int i=0; i<len; i++) {
			ce+=pairs[i].dur;
			ans+=(pairs[i].ft)-ce;
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		int dur, ft;
		public Pair(int a, int b) {
			this.dur=a;
			this.ft = b;
		}
		@Override
		public int compareTo(Pair o) {
			return this.dur-o.dur;
		}
		
	}
}
