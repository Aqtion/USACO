
/*
ID: grifync1
LANG: JAVA
PROG: breedcounting
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class breedcounting {
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
		BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int q = conv(st.nextToken());
		int[] nums = new int[n];
		int[] holst = new int[n];
		int[] guern = new int[n];
		int[] jer = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = conv(in.readLine());
			
		}
		if(nums[0]==1)
			holst[0]=1;
		else if(nums[0]==2)
			guern[0]=1;
		else
			jer[0]=1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==1) {
				holst[i]=1+holst[i-1];
				guern[i]=guern[i-1];
				jer[i]=jer[i-1];
			}
			else if(nums[i]==2) {
				holst[i]=holst[i-1];
				guern[i]=1+guern[i-1];
				jer[i]=jer[i-1];
			}
			else if(nums[i]==3) {
				holst[i]=holst[i-1];
				guern[i]=guern[i-1];
				jer[i]=1+jer[i-1];
			}
		}
		for(int i=0; i<q; i++) {
			int h = 0;
			int g = 0;
			int j = 0;
			st = new StringTokenizer(in.readLine());
			int s = conv(st.nextToken());
			int e = conv(st.nextToken());
			if(s==1) {
				h=holst[e-1];
				g = guern[e-1];
				j=jer[e-1];
			}
			else {
				h=holst[e-1]-holst[s-2];
				g=guern[e-1]-guern[s-2];
				j=jer[e-1]-jer[s-2];
			}
			out.println(h+" "+g+" "+j);
 		}
		
		in.close();
		out.close();
	}

}
