/*
ID: grifync1
LANG: JAVA
PROG: candies
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class candies {
	static int[] prefix = new int[(int) (2*Math.pow(10,5))+1];
	static int[] invprefix = new int[(int) (2*Math.pow(10,5))+1];
	static int c = 0;
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
		//BufferedReader in = new BufferedReader(new FileReader("candies.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("candies.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = conv(st.nextToken());
			int q = conv(st.nextToken());
			int[] candies = new int[n+1];
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=n; j++) {
				candies[j]=conv(st.nextToken());
			}
			upr(prefix, invprefix, candies);
			int ans = 0;
			for(int j=0; j<q; j++) {
				 st = new StringTokenizer(in.readLine());
				 String w = st.nextToken();
				 if(w.equals("U")) {
					 int r = conv(st.nextToken());
					 int v = conv(st.nextToken());
					 candies[r]=v;
					 upr(prefix, invprefix, candies);
				 }
				 else {
					 int l = conv(st.nextToken());
					 int r = conv(st.nextToken());
					 int a = 0;
					 if(l==1) {
						ans+=invprefix[r];
					 }
					 else {
						 a = (int) ((Math.pow(-1, l-1)))*((invprefix[r]-invprefix[l-1])-(l-1)*(prefix[r]-prefix[l-1]));
					 }
					 ans+=a;
				 }
			}
			out.println("Case #" + (i+1)+":"+ans);
		}
		in.close();
		out.close();
	}
	public static void upr(int[] p, int[] ip, int[] c) {
		p[1]=c[1];
		ip[1]=c[1];
		for(int i=2; i<c.length; i++) {
			p[i]=(int) (Math.pow(-1, i-1))*c[i]+p[i-1];
			ip[i]=(int) (Math.pow(-1, i-1))*c[i]*(i)+ip[i-1];;
		}
	}
}
