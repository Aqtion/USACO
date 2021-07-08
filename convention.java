
/*
ID: grifync1
LANG: JAVA
PROG: convention
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class convention {
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
		///BufferedReader in = new BufferedReader(new FileReader("convention.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int m = conv(st.nextToken());
		int c = conv(st.nextToken());
		int[] cows = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			cows[i]=conv(st.nextToken());
		}
		sort(cows);
		long low = 0;
		long high = (int) Math.pow(10,9);
		
		while(low<high) {
			long mid = (low+high)/2;
			out.println(low+" "+high);
			if(jobytoby(mid, cows, c)) {
				
				high=mid;
			}
			else {
				low=mid+1;
			}
		}
		out.println(high);
 		in.close();
		out.close();
	}
	public static boolean jobytoby(long max, int[] cows, int c) {
		int min = cows[0];
		int cap = 0;
		for(int i=0; i<cows.length; i++) {
			if((long)(cows[i])-min>max) {
				min=cows[i];
				cap++;
			}
			
		}
		System.out.println(cap);
		return (cap<=c);
	}
}
