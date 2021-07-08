
/*
ID: grifync1
LANG: JAVA
PROG: forestqueries
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class forestqueries {
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
		//BufferedReader in = new BufferedReader(new FileReader("forestqueries.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("forestqueries.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		int[][] forest = new int[n+1][n+1];
		for(int i=0; i<n; i++) {
			String s = in.readLine();
			for(int j=0; j<n; j++) {
				forest[i+1][j+1]=(s.charAt(j)=='.')?0:1;
			}
		}
		int[][] fqs = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				fqs[i][j]=fqs[i-1][j]+fqs[i][j-1]-fqs[i-1][j-1]+forest[i][j];
			}
		}
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			int a1 = conv(st.nextToken());
			int b1 = conv(st.nextToken());
			out.println(fqs[a1][b1]-fqs[a-1][b1]-fqs[a1][b-1]+fqs[a-1][b-1]);
		}
		in.close();
		out.close();
	}

}
