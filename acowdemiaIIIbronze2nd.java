
/*
ID: grifync1
LANG: JAVA
PROG: acowdemiaIIIbronze2nd
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class acowdemiaIIIbronze2nd {
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
		//BufferedReader in = new BufferedReader(new FileReader("acowdemiaIIIbronze2nd.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("acowdemiaIIIbronze2nd.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r = conv(st.nextToken());
		int c = conv(st.nextToken());
		char[][] grid = new char[r][c];
		for(int i=0; i<r; i++) {
			String s= in.readLine();
			for(int j=0; j<c; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		
		in.close();
		out.close();
	}

}
