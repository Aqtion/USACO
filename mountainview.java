
/*
ID: grifync1
LANG: JAVA
PROG: mountainview
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class mountainview {
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
		//BufferedReader in = new BufferedReader(new FileReader("mountainview.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountainview.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		Pair[] peaks = new Pair[len];
		
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			peaks[i]= new Pair(a,b);
		}
		Arrays.sort(peaks);
		int ans = 0;
		int max = -1;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(peaks[i].x-peaks[j].x >= peaks[i].y-peaks[j].y) {
					if(peaks[i].x+peaks[j].x <= peaks[i].y+peaks[j].y) {
						if(peaks[i].y+peaks[j].y>max) {
							max = peaks[i].y+peaks[j].y;
						}
						else {
							ans++;
						}
					}
				}
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		int x, y;
		public Pair(int f, int e) {
			this.x=f;
			this.y=e;
		}
		@Override
		public int compareTo(Pair o) {
			return this.y-o.y;
		}
		
	}
}
