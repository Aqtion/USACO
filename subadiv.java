
/*
ID: grifync1
LANG: JAVA
PROG: subasum2
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class subadiv {
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
		//BufferedReader in = new BufferedReader(new FileReader("subasum2.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subasum2.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		int n = conv(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i]=conv(st.nextToken());
		}
		int rp = 0;
		long ans = 0;
		long sum = 0;
		map.put(0L,1);
		while(rp<n) {
			sum += nums[rp];
			long rem = sum%n;
			if(rem<0) {
				rem+=n;
			}
			if(map.containsKey(rem)) {
				ans+=map.get(rem);
			}
			int count = map.getOrDefault(rem,0);
			count++;
			map.put(rem,count);
			rp++;	
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
