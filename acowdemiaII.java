

/*
ID: grifync1
LANG: JAVA
PROG: acowdemiaII
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class acowdemiaII {
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
		//BufferedReader in = new BufferedReader(new FileReader("acowdemiaII.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("acowdemiaII.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int k = conv(st.nextToken());
		int n = conv(st.nextToken());
		String[] names = new String[n];
		st = new StringTokenizer(in.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			names[i]=st.nextToken();
			map.put(names[i], i);
		}
		String[][] nl = new String[k][n];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				nl[i][j]=st.nextToken();
			}
		}
		//:O
		char[][] ans = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j==i) {
					ans[i][j]='B';
				}
				else {
					ans[i][j]='?';
				}
			}
		}
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<n; j++) {
				boolean fg = false;
				for(int p=j+1; p<n; p++) {
					if(nl[i][p-1].compareTo(nl[i][p])>0) {
						fg = true;
					}
					if(fg) {
						ans[map.get(nl[i][j])][map.get(nl[i][p])]='0';
						ans[map.get(nl[i][p])][map.get(nl[i][j])]='1';
					}

				}
			}
		}
		for(char[] c: ans) {
			for(char p: c) {
				out.print(p);
			}
			out.println();
		}
		in.close();
		out.close();
	}

}
