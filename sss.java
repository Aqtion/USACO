
/*
ID: grifync1
LANG: JAVA
PROG: sss
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class sss {
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
		BufferedReader in = new BufferedReader(new FileReader("div7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] nums = new int[len];
		long[] prefix = new long[len];
		for(int i=0; i<len; i++) {
			nums[i]=conv(in.readLine());
		}
		//remainder-index
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		prefix[0]=nums[0];
		map.put(prefix[0]%7, 0);
		int maxlen = -1;
		for(int i=1; i<len; i++) {
			prefix[i]=(nums[i]+prefix[i-1]);
			long rem = prefix[i]%7;
			if(map.containsKey(rem)) {
				maxlen = max(maxlen, i-map.get(rem));
			}
			else {
				map.put(rem, i);
			}
		}
		out.println(maxlen);
		in.close();
		out.close();
	}

}
