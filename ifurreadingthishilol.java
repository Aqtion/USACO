
/*
ID: grifync1
LANG: JAVA
PROG: ifurreadingthishilol
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;



import java.io.*;

public class ifurreadingthishilol {
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
		//BufferedReader in = new BufferedReader(new FileReader("ifurreadingthishilol.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ifurreadingthishilol.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		int l = conv(st.nextToken());
		Integer[] citations = new Integer[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			citations[i] = conv(st.nextToken());
		}
		Arrays.sort(citations);
		int low = 1;
		int high = n;
		int ans = 1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(isPossible(mid, k, l, citations)) {
				ans = max(ans, mid);
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	public static boolean isPossible(int hindex, int k, int l, Integer[] citations) {
		int end = citations.length-1;
		int num = hindex;
 		long cn = 0;
		while(num>0) {
			if(citations[end]<hindex) {
				cn+=(long)(hindex-citations[end]);
				if(Math.abs(hindex-citations[end])>k) {
					return false;
				}
			}
			num--;
			end--;
		
		}
		if(cn<=((long)l)*((long)k)) {
			return true;
		}
		return false;
	}
}

