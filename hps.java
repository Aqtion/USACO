
/*
ID: grifync1
LANG: JAVA
PROG: hps
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class hps {
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
		BufferedReader in = new BufferedReader(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		///StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] h = new int[len];
		int[] s = new int[len];
		int[] p = new int[len];
		char[] moves = new char[len];
		for(int i=0; i<len; i++) {
			String str = in.readLine();
			
			moves[i]=str.charAt(0);
		}
		if(moves[0]=='P') {
			p[0]=1;
		}
		else if(moves[0]=='S') {
			s[0]=1;
		}
		else if(moves[0]=='H') {
			h[0]=1;
		}
		for(int i=1; i<len; i++) {
			s[i]=s[i-1];
			h[i]=h[i-1];
			p[i]=p[i-1];
			if(moves[i]=='P') {
				p[i]++;
			}
			else if(moves[i]=='S') {
				s[i]++;
			}
			else if(moves[i]=='H') {
				h[i]++;
			}
		}
		int ans = -1;
		for(int i=0; i<len; i++) {
			if(i==0) {
				int monx = max(p[len-1], max(s[len-1], h[len-1]));
				ans = max(ans, monx);
				continue;
			}
			else {
				int mots = max(p[i], max(s[i], h[i]));
				int monx = max(p[len-1]-p[i], max(s[len-1]-s[i], h[len-1]-h[i]));
				ans = max(ans, mots+monx);
			}
		}
		out.println( ans);
		in.close();
		out.close();
	}

}
