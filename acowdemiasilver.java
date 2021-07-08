
/*
ID: grifync1
LANG: JAVA
PROG: acowdemiaI
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class acowdemiasilver {
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
		// BufferedReader in = new BufferedReader(new FileReader("acowdemiaI.in"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new
		// FileWriter("acowdemiaI.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		// StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(st.nextToken());
		int K = conv(st.nextToken());
		int L = conv(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = conv(st.nextToken());
		}
		sort(nums);
		int end = len - 1;
		int hindex = 0;
		while (end >= 0) {
			if (nums[end] >= hindex + 1) {
				hindex++;
			} else {
				break;
			}
			end--;
		}
		int prevl = L;
		int prevk = K;
		while(K>0) {
			if (L > 0) {
				end = len - 1;
				int cnt = 0;
				while (end >= 0) {
					if (nums[end] == hindex && L > 0) {
						L--;
						nums[end]++;
					}
					end--;
				}
				end = len - 1;
				hindex = 0;
				while (end >= 0) {
					if (nums[end] >= hindex + 1) {
						hindex++;
					} else {
						break;
					}
					end--;
				}
			}
			L=prevl;
			K--;
		}
		out.println(hindex);
		in.close();
		out.close();
	}

}
