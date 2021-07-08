
/*
ID: grifync1
LANG: JAVA
PROG: moviefestivalII
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class moviefestivalII {
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
		//BufferedReader in = new BufferedReader(new FileReader("moviefestivalII.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moviefestivalII.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		movie[] movies = new movie[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			movies[i] = new movie(b,a);
		}
		Arrays.sort(movies);
		TreeSet<movie> ts = new TreeSet<movie>();
		for(int i=0; i<n; i++) {
			
		}
		in.close();
		out.close();
	}
	static class movie implements Comparable<movie>{
		int e,s;
		public movie(int a, int b) {
			this.e=a;
			this.s=b;
		}
		@Override
		public int compareTo(movie o) {
			return this.e-o.e;
		}
		
	}
}
