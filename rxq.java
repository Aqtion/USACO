
/*
ID: grifync1
LANG: JAVA
PROG: rxq
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class rxq {
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
		//BufferedReader in = new BufferedReader(new FileReader("rxq.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rxq.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(st.nextToken());
		int ranges = conv(st.nextToken());
		int[] nums = new int[len];
		long[] prefix = new long[len+1]; st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			nums[i]=conv(st.nextToken());
		}	
		prefix[0]=1;
		for(int i=0; i<len; i++) {
			prefix[i+1]=(prefix[i]^nums[i]);
		}
		for(int i=0; i<ranges; i++) {
			st = new StringTokenizer(in.readLine());
			int s = conv(st.nextToken());
			int e = conv(st.nextToken());	
			out.println(prefix[e]^prefix[s-1]);
		}
		in.close();
		out.close();
	}

}
