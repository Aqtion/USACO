
/*
ID: grifync1
LANG: JAVA
PROG: balancedteams
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class balancedteams {
	static int ans = Integer.MAX_VALUE;
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
		//BufferedReader in = new BufferedReader(new FileReader("balancedteams.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancedteams.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int[] skills = new int[12];
		for(int i=0; i<12; i++) {
			skills[i]=conv(in.readLine());
		}
		recurse(skills, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		out.println(ans);
		in.close();
		out.close();
	}
	public static void recurse(int[] skills, int index,int fs, int ss, int ts, int fos, int fc, int sc, int tc, int foc) {
		if(index>=12) {
			if(fc==sc && sc==tc && tc==foc && foc==3) {
				int max = Math.max(fs, Math.max(ss, Math.max(ts, fos)));
				int min = Math.min(fs, Math.min(ss, Math.min(ts, fos)));
				ans = Math.min(max-min, ans);
				return;
			}
			
		}
		for(int i=index; i<12; i++) {			
			recurse(skills, i+1, fs+skills[i], ss, ts, fos, fc+1, sc, tc, foc);
			recurse(skills, i+1, fs, ss+skills[i], ts, fos, fc, sc+1, tc, foc);
			recurse(skills, i+1, fs, ss, ts+skills[i], fos, fc, sc, tc+1, foc);
			recurse(skills, i+1, fs, ss, ts, fos+skills[i], fc, sc, tc, foc+1);
			
		}
	}
	public static int listsum(List<Integer> list) {
		int sum = 0;
		for(int i: list) {
			sum+=i;
		}
		return sum;
	}
}
