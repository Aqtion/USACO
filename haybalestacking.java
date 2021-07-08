
/*
ID: grifync1
LANG: JAVA
PROG: haybalestacking
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class haybalestacking {
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
		//BufferedReader in = new BufferedReader(new FileReader("haybalestacking.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybalestacking.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(st.nextToken());
		int k = conv(st.nextToken());
		int[] stacks = new int[len];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int f = conv(st.nextToken());
			int e = conv(st.nextToken());
			for(int j=f; j<e; j++) {
				stacks[j]++;
			}
		}
		sort(stacks);
		out.println(stacks[len/2]);
		in.close();
		out.close();
	}

}
