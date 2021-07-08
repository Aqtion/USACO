
/*
ID: grifync1
LANG: JAVA
PROG: trafficlights
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class trafficlights {
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
		//BufferedReader in = new BufferedReader(new FileReader("trafficlights.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trafficlights.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int sl = conv(st.nextToken());
		int tls = conv(st.nextToken());
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(0);
		ts.add(sl);
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<tls; i++) {
			int t = conv(st.nextToken());
			int a = ts.lower(t);
			int h = ts.higher(t);
			int dist = h-a;
			if(tm.containsKey(dist)) {
				if(tm.get(dist)==1) {
					tm.remove(dist);
				}
				else {
					tm.put(dist, tm.get(dist)-1);
				}
			}
			tm.put(h-t, tm.getOrDefault(h-t, 0)+1);
			tm.put(t-a, tm.getOrDefault(t-a, 0)+1);
			ts.add(t);
			out.print(tm.lastKey()+" ");
		}
		in.close();
		out.close();
	}

}
