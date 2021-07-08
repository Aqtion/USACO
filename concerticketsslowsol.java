
/*
ID: grifync1
LANG: JAVA
PROG: concertickets
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class concerticketsslowsol {
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
		//BufferedReader in = new BufferedReader(new FileReader("concertickets.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concertickets.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int m = conv(st.nextToken());
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int a = conv(st.nextToken());
			if(!tm.containsKey(a)) {
				int f = 1;
				tm.put(a, f);
			}
			else {
				int f = tm.get(a);
				f++;
				tm.put(a, f);
			}
		}
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) {
			int w = conv(st.nextToken());
			if(tm.containsKey(w)) {
				out.println(w);
				if(tm.get(w)==1) {
					tm.remove(w);
				}
				else {
					int f = tm.get(w);
					f--;
					tm.put(w, f);
				}
			}
			else if((tm.lowerKey(w)!=null && tm.containsKey(tm.lowerKey(w))) ) {
				if(tm.containsKey(w)) {
					out.println(w);
				}
				else {
					out.println(tm.lowerKey(w));
				}
				if(tm.get(tm.lowerKey(w))==1) {
					tm.remove(tm.lowerKey(w));
				}
				else {
					int f = tm.get(tm.lowerKey(w));
					f--;
					tm.put(tm.lowerKey(w), f);
				}
			}
			else {
				out.println(-1);
			}
		}
		in.close();
		out.close();
	}

}
