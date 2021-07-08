
/*
ID: grifync1
LANG: JAVA
PROG: concertickets
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class concertickets {
	static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();
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
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int a = conv(st.nextToken());
			add(a);
		}
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) {
			int p = conv(st.nextToken());
			if(multiset.containsKey(p)) {
				out.println(p);
				if(multiset.get(p)==1) {
					remove(p);
				}
				else {
					multiset.put(p, multiset.get(p)-1);
				}
			}
			if(multiset.containsKey(multiset.lowerKey(p))) {
				out.println(multiset.lowerKey(p));
				if(multiset.get(multiset.lowerKey(p))==1) {
					multiset.remove(multiset.lowerKey(p));
				}
				else {
					multiset.put(multiset.lowerKey(p), multiset.get(multiset.lowerKey(p))-1);
				}
			}
		}
		in.close();
		out.close();
	}
	static void add(int x){
		if(multiset.containsKey(x)){
			multiset.put(x, multiset.get(x) + 1);
		} else {
			multiset.put(x, 1);
		}
	}

	static void remove(int x){
		multiset.put(x, multiset.get(x) - 1);
		if(multiset.get(x) == 0){
			multiset.remove(x);
		}
	}
}
