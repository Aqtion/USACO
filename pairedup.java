
/*
ID: grifync1
LANG: JAVA
PROG: pairedup
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class pairedup {
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
		BufferedReader in = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		List<Pair> list = new ArrayList<Pair>();
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int f  = conv(st.nextToken());
			int e = conv(st.nextToken());
			list.add(new Pair(f, e));
		}
		Collections.sort(list);
		int m = -1;
		while(list.size()>0) {
			Pair lc = list.get(0);
			Pair rc = list.get(list.size()-1);
			m = max(m, lc.t+rc.t);
			if(list.size()==1) {
				break;
			}
			if(lc.cs<rc.cs) {
				list.remove(0);
				rc.cs-=lc.cs;
			}
			else if(rc.cs<lc.cs) {
				list.remove(list.size()-1);
				lc.cs-=rc.cs;
			}
			else {
				list.remove(0);
				list.remove(list.size()-1);
			}
		}
		out.println(m);
 		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		int cs,  t;
		public Pair(int a, int b) {
			this.cs=a;
			this.t=b;
		}
		@Override
		public int compareTo(Pair o) {
			return this.t-o.t;
		}
	}

}
