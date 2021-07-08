
/*
ID: grifync1
LANG: JAVA
PROG: wdtcctr2
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class wdtcctr2 {
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
		BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		int b = conv(st.nextToken());
		int[] nums = new int[b];
		for(int i=0; i<b; i++) {
			nums[i]=conv(in.readLine());
		}
		int[] prefix = new int[n+1];
		sort(nums);
		int[] place = new int[n+1];
		Arrays.fill(place,0);
		for(int i: nums) {
			place[i]=1;
		}
		prefix[1]=place[1];
		for(int i=2; i<=n; i++) {
			prefix[i]=(prefix[i-1]+place[i]);
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=2; i<=n-k+1; i++) {
			ans = min(ans, prefix[i+k-1]-prefix[i-1]);
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
