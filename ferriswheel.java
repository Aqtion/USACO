
/*
ID: grifync1
LANG: JAVA
PROG: ferriswheel
*/

//lil lil peezy
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class ferriswheel {
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
		//BufferedReader in = new BufferedReader(new FileReader("ferriswheel.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ferriswheel.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int children = conv(st.nextToken());
		int maxw = conv(st.nextToken());
		int[] chldr = new int[children];
		st = new StringTokenizer(in.readLine());
		boolean[] occ = new boolean[(int) (2*Math.pow(10,5))];
		Arrays.fill(occ, false);
		for(int i=0; i<children; i++) {
			chldr[i]=conv(st.nextToken());
		}
		Arrays.sort(chldr);
		int f = 0;
		int b = children-1;
		int ans = 0;
		while(f<b) {
			if(chldr[f]+chldr[b]>maxw) {
				b--;
			}
			else {
				ans++;
				occ[f]=true;
				occ[b]=true;
				f++;
				b--;
			}
		}
		for(int i=0; i<children; i++) {
			if(!occ[i]) {
				ans++;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
