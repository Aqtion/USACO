
/*
ID: grifync1
LANG: JAVA
PROG: something
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class measurement {
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
		BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(st.nextToken());
		int G = conv(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<Integer ,Integer>();
		TreeMap<Integer, Integer> tm = new TreeMap<Integer ,Integer>();
		cow[] cows = new cow[len];
		for(int i=0; i<len; i++) {
			st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			String s = st.nextToken();
			if(s.charAt(0)=='+') {
				cows[i] = new cow(a, b, Integer.parseInt(s.substring(1)));
				
			}
			else {
				cows[i] = new cow(a, b, -Integer.parseInt(s.substring(1)));
			}
		}
		Arrays.sort(cows);
		tm.put(G, 100001);
		int ans = 0;
		for(int i=0; i<len; i++) {
			int prevf = tm.get(tm.lastKey());
			int plk = tm.lastKey();
			int s = map.getOrDefault((cows[i].id),G);
			tm.put(s, (tm.get(s)-1));
			if(tm.get(s)==0) {
				tm.remove(s);
			}
			int ns = s+cows[i].change;
			map.put(cows[i].id, ns);
			tm.put(ns, (tm.getOrDefault(ns, 0)+1));
			if(tm.get(tm.lastKey())!=prevf || (ns>plk && s<plk) || (s>tm.lastKey() && ns<tm.lastKey())) {
				ans++;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class cow implements Comparable<cow>{
		int day, id, change;
		public cow(int a, int b, int c) {
			this.day=a;
			this.id = b;
			this.change = c;
		}
		@Override
		public int compareTo(cow o) {
			return this.day-o.day;
		}
		
	}
}
