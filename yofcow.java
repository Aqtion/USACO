
/*
ID: grifync1
LANG: JAVA
PROG: yofcow
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class yofcow {
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
		//BufferedReader in = new BufferedReader(new FileReader("yofcow.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("yofcow.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		int[] nums = new int[n+1];
		for(int i=0; i<n; i++) {
			nums[i]=conv(in.readLine());
		}
		int[] gaps = new int[n];
		nums[n]=0;
		sort(nums);
		for(int i=0; i<n; i++) {
			int b = (nums[i+1]/12)*12;
			int a = ((nums[i]+11)/12)*12;
			gaps[i]=b-a;
		}
		sort(gaps);
		int sta = ((nums[n]+11)/12)*12;
		for(int i=n-1; i>=n-k+1; i--) {
			sta-=gaps[i];
		}
		out.println(sta);
 		in.close();
		out.close();
	}

}
