
/*
ID: grifync1
LANG: JAVA
PROG: restaurantcustomers
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class restaurantcustomersII {
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
		Pair[] times = new Pair[len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long f = conv(st.nextToken());
			int e = conv(st.nextToken());
			times[i] = new Pair(f, e);
		}
		Arrays.sort(times);
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<len; i++) {
			Pair p = times[i];
			while(!pq.isEmpty() && p.a>pq.peek()) {
				pq.poll();
			}
			pq.add(times[i].l);
			ans = max(ans, pq.size());
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		long a; int l;
		public Pair(long x, int y) {
			this.a=x;
			this.l=y;
		}
		@Override
		public int compareTo(Pair o) {
			return (int) (this.a-o.a);
		}
	}
}
