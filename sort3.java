
/*
ID: grifync1
LANG: JAVA
PROG: sort3
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class sort3 {
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
		//BufferedReader in = new BufferedReader(new FileReader("sort3.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] medals = new int[len];
		
		int ones = 0;
		int twos = 0;
		int threes = 0;
		for(int i=0; i<len; i++) {
			medals[i] = conv(in.readLine());
			if(medals[i]==1) {
				ones++;
			}
			else if(medals[i]==2) {
				twos++;
			}
			else {
				threes++;
			}
		}
		int swaps = 0;
		for(int i=0; i<len; i++) {
			if(i<=ones-1) {
				if(medals[i]!=1) {
					swaps++;
				}
			}
			else if(i<=twos-1){
				if(medals[i]!=2) {
					swaps++;
				}
			}
			else if(i<=threes-1) {
				if(medals[i]!=3) {
					swaps++;
				}
			}
		}
		out.println(swaps);
		in.close();
		out.close();
	}

}
