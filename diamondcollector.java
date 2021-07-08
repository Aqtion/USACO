
/*
ID: grifync1
LANG: JAVA
PROG: diamondcollector
*/

//lil lil peezy
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class diamondcollector {
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
		//BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		int[] diamonds = new int[n];
		for(int i=0; i<n; i++) {
			diamonds[i]=conv(in.readLine());
		}
		int[] left = new int[n];
		int[] right = new int[n];
		sort(diamonds);
		int lp = 0;
		int rp = 0;
		int max = 0;
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		while(lp<=rp && rp<n) {
			if(diamonds[rp]-diamonds[lp]<=k) {
				max++;
				rp++;
			}
			else {
				left[lp]=max;
				max=0;
				lp++;
			}
		}
		lp = n-1;
		rp = n-1;
		max = 0;
		while(lp>0 && rp>=lp) {
			if(diamonds[rp]-diamonds[lp]<=k) {
				max++;
				lp--;
			}
			else {
				right[rp]=max;
				max = 1;
				rp--;
			}
		}
		int ans = -1;
		for(int i=0; i<n; i++) {
			int f = 0;
			int cm = -1;
			while(f<i) {
				cm=max(cm, max(right[f] ,left[f]));
				f++;
			}
			int f1 = i;
			int cm1 = -1;
			while(f1<n) {
				cm1 = max(cm1, max(right[f1], left[f1]));
				f1++;
			}
			ans = max(ans, cm1+cm);
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
