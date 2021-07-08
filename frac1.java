
/*
ID: grifync1
LANG: JAVA
PROG: frac1
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class frac1 {
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
		BufferedReader in = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int N = conv(in.readLine());
		TreeMap<Float, String> tm = new TreeMap<Float, String>();
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				BigInteger bi1 = BigInteger.valueOf(i);
				BigInteger bi2 = BigInteger.valueOf(j);
				BigInteger gcd = bi1.gcd(bi2);
				if(gcd.intValue()==1) {
					tm.put((float)(bi1.intValue())/(float)(bi2.intValue()), bi1+"/"+bi2);
				}
			}
		}
		for(Float f: tm.keySet()) {
			out.println(tm.get(f));
		}
		out.println("1/1");
		in.close();
		out.close();
	}

}
