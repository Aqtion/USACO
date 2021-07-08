

/*
ID: grifync1
LANG: JAVA
PROG: lemonade
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class lemonade {
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
		BufferedReader in = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] waits = new int[len];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			waits[i]=conv(st.nextToken());
		}
		sort(waits);
		int tt = 0;
		int ans = 0;
		for(int i=len-1; i>=0; i--) {
			if(tt>waits[i]) {
				break;
			}
			else {
				tt++;
				ans++;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
