
/*
ID: grifync1
LANG: JAVA
PROG: kablames
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class kablames {
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
		//BufferedReader in = new BufferedReader(new FileReader("kablames.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kablames.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int[] nums = new int[] {2,3,4,5,6,-1,3};
		
		int ans = nums[0];
		int tmpmax = 0;
		for(int i=0;  i<7; i++) {
			tmpmax+=nums[i];
			ans = max(ans,tmpmax);
			tmpmax = (tmpmax<0)?0:tmpmax;
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
