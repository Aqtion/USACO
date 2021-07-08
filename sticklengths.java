

/*
ID: grifync1
LANG: JAVA
PROG: sticklengths
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class sticklengths {
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
		//BufferedReader in = new BufferedReader(new FileReader("sticklengths.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sticklengths.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		long[] sticks = new long[len];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			sticks[i]=conv(st.nextToken());
		}
		Arrays.sort(sticks);
		long median = sticks[len/2];
		long cost = 0;
		for(int i=0; i<len; i++) {
			cost+=Math.abs(median-sticks[i]);
		}
		out.println(cost);
		in.close();
		out.close();
	}

}
