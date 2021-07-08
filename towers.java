
/*
ID: grifync1
LANG: JAVA
PROG: towers
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class towers {
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
		//BufferedReader in = new BufferedReader(new FileReader("towers.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("towers.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] towers = new int[len];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			towers[i]=conv(st.nextToken());
		}
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		int ans = 0;
		for(int i=0; i<len; i++) {
			if(tm.higherKey(towers[i])==null) {	
				ans++;
			}
			else {
				int cnt = tm.get(tm.higherKey(towers[i]));
				if(cnt == 1) {
					tm.remove(tm.higherKey(towers[i]));
				}
				else {
					tm.put(tm.higherKey(towers[i]), cnt-1);
				}
			}
			tm.put(towers[i], tm.getOrDefault(towers[i], 0)+1);
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
