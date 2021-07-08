
/*
ID: grifync1
LANG: JAVA
PROG: hamming
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class hamming {
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
		BufferedReader in = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = conv(st.nextToken());
		int B = conv(st.nextToken());
		int D = conv(st.nextToken());
		List<Integer> codewords = new ArrayList<Integer>();
		for(int i=0; i<3000; i++) {
			if(codewords.size()==N) {
				break;
			}
			boolean ok = true;
			for(int comp: codewords) {
				if(!check(i, comp, D)) {
					ok=false;
				}
			}
			if(ok) {
				codewords.add(i);
			}
		}
		int cnt = 0;
		int total = 0;
		for(int i: codewords) {
			if(total+1==codewords.size()) {
				out.print(i);
				break;
			}
			if(cnt==10) {
				out.println();
				out.print(i+" ");
				cnt=1;
				total++;
				continue;
			}
			if(cnt+1==10) {
				out.print(i);
				cnt++;
				total++;
				continue;
			}
			out.print(i+" ");
			total++;
			cnt++;
		}
		out.println();
		in.close();
		out.close();
	}
	public static boolean check(int a, int b, int hammingd) {
		String diff = Integer.toBinaryString((a^b)>>0);
		int cnt = 0;
		for(int i=0; i<diff.length(); i++) {
			if(diff.charAt(i)=='1') {
				cnt++;
			}
		}
		return cnt>=hammingd;
	}
}
