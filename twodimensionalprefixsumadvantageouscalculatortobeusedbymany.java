
/*
ID: grifync1
LANG: JAVA
PROG: twodimensionalprefixsumadvantageouscalculatortobeusedbymany
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class twodimensionalprefixsumadvantageouscalculatortobeusedbymany {
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
		//BufferedReader in = new BufferedReader(new FileReader("twodimensionalprefixsumadvantageouscalculatortobeusedbymany.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("twodimensionalprefixsumadvantageouscalculatortobeusedbymany.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[][] grid = new int[len][len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<len; j++) {
				grid[i][j]=conv(st.nextToken());
			}
		}
		int[][] prefix = new int[len][len];
		prefix[0][0]=grid[0][0];
		for(int i=1; i<len; i++) {
			prefix[i][0]=prefix[i-1][0]+grid[i][0];
			prefix[0][i]=prefix[0][i-1]+grid[0][i];
		}
		for(int i=1; i<len; i++) {
			for(int j=1; j<len; j++) {
				prefix[i][j]=prefix[i][j-1]+prefix[i-1][j]-prefix[i-1][j-1]+grid[i][j];
			}
		}
		for(int[] a: prefix) {
			for(int b: a) {
				out.print(b+" ");
			}
			out.println();
		}
		in.close();
		out.close();
	}

}
