
/*
ID: grifync1
LANG: JAVA
PROG: maxsubsum
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class maxsubsum {
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
		//BufferedReader in = new BufferedReader(new FileReader("maxsubsum.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxsubsum.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] nums = new int[len];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			nums[i]=conv(st.nextToken());
		}
		long[] prefix = new long[len];
		prefix[0]=nums[0];
		for(int i=1; i<len; i++) {
			prefix[i]=(prefix[i-1]+nums[i]);
		}
		/*
			for int i = 0 i less than n i ++
			   for int j = i j less than n j++
			      
		 */
		long min = 0;
		long ans = Long.MIN_VALUE;
		for(int i=0; i<len; i++) {
			ans = Math.max(ans, prefix[i]-min);
			min = Math.min(min, prefix[i]);
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
