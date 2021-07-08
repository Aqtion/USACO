
/*
ID: grifync1
LANG: JAVA
PROG: moocast
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class moocast {
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
		BufferedReader in = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		///StringTokenizer st = new StringTokenizer(in.readLine());
		int cows = conv(in.readLine());
		Point[] points = new Point[cows];
		for(int i=0; i<cows; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			int c = conv(st.nextToken());
			points[i] = new Point(a, b, c*c, i);
		}
		int ans = -1;
		for(int i=0; i<cows; i++) {
			boolean[] visited = new boolean[cows];
			ans=max(ans, dfs(points[i], visited, points));
		}
		out.println(ans);
		in.close();
		out.close();
	}
	public static int dfs(Point a, boolean[] visited, Point[] points) {
		visited[a.index]=true;
		int ans = 1;
		for(int i=0; i<points.length; i++) {
			if(i!=a.index && !visited[i]) {
				int distance = ((a.x-points[i].x)*(a.x-points[i].x))+((a.y-points[i].y)*(a.y-points[i].y));
				if(distance<=a.power) {
					ans+=dfs(points[i], visited, points);
				}
			}
		}
		return ans;
	}
	static class Point {
		int x, y, power, index;
		public Point(int a, int b, int c, int d) {
			this.x=a;
			this.y=b;
			this.power=c;
			this.index=d;
		}
	}
	
}
