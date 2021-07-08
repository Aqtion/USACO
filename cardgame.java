
/*
ID: grifync1
LANG: JAVA
PROG: highcardwins
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class cardgame {
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
		BufferedReader in = new BufferedReader(new FileReader("cardgame.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		boolean[] cards = new boolean[2*len];
		Arrays.fill(cards, false);
		int[] ec1 = new int[len/2];
		int[] ec2 = new int[len/2];
		for(int i=0; i<len; i++) {
			int n = conv(in.readLine());
			cards[n-1]=true;
			if(i<len/2) {
				ec1[i]=n;
			}
			else {
				ec2[i-len/2]=n;
			}
		}
		Arrays.sort(ec1);
		int ind = 0;
		int[] bc = new int[len];
		for(int i=0; i<cards.length; i++) {
			if(!cards[i] && ind<len) {
				bc[ind]=i+1;
				ind++;
			}
		}
		Arrays.sort(ec2);
		int res = 0;
		int prev1 = len/2;
		for(int i=0; i<len/2; i++) {
			int a = ec1[i];
			int j = prev1;
			while(j<len && bc[j]<a) {
				j++;
			}
			if(j<len) {
				res++;
				j++;
			}
			prev1 = j;
		}
		int prev = 0;
		for(int i=len/2; i<len; i++) {
			int a = ec2[i-len/2];
			int j = prev;
			boolean c = false;
			while(j<len/2 && bc[j]>a) {
				c=true;
				break;
			}
			if(j<len/2 && !c) {
				res++;
				j++;
			}
			prev = j;
		}
		out.println(res);
		in.close();
		out.close();
	}

}
