
/*
ID: grifync1
LANG: JAVA
PROG: cellularnetwork
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class cellularnetwork {
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
		//BufferedReader in = new BufferedReader(new FileReader("cellularnetwork.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cellularnetwork.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int m = conv(st.nextToken());
		Integer[] cities = new Integer[n];
		Integer[] towers = new Integer[m];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			cities[i]=conv(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) {
			towers[i]=conv(st.nextToken());
		}
		int tp = 0;
		int min = -1;
		Arrays.sort(cities);
		Arrays.sort(towers);
		for(int cp=0; cp<n; cp++) {
			while(tp+1<m && Math.abs(towers[tp+1]-cities[cp])<=Math.abs(towers[tp]-cities[cp])) {
				tp++;
			}
			min=max(min,Math.abs(towers[tp]-cities[cp]));
		}
		out.println(min);
		in.close();
		out.close();
	}

}
