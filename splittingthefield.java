
/*
ID: grifync1
LANG: JAVA
PROG: splittingthefield
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class splittingthefield {
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
		BufferedReader in = new BufferedReader(new FileReader("split.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		Point[] points = new Point[len];
		int minx = Integer.MAX_VALUE;
		int maxx = -1;
		int miny = Integer.MAX_VALUE;
		int maxy = -1;
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			minx = min(minx, a);
			maxx= max(maxx, a);
			miny=  min(miny, b);
			maxy = max(maxy, b);
			points[i] = new Point(a, b);
		}
		
		long prt = horiz(points, len, maxx, minx, maxy, miny);
		for(int i=0; i<len; i++) {
			int tmp = points[i].y;
			points[i].y=points[i].x;
			points[i].x=tmp;
		}
		long pt = horiz(points, len, maxx, minx, maxy, miny);
		out.println(Math.max(pt, prt));
		in.close();
		out.close();
	}
	static class Point implements Comparable<Point>{
		int x,y;
		public Point(int a, int b) {
			this.x=a;
			this.y=b;
		}
		@Override
		public int compareTo(Point o) {
			return this.x-o.x;
		}
		
	}
	public static long horiz(Point[] points, int len, int maxx, int minx, int maxy, int miny) {
		int[][] mim = new int[len][2];
		int[][] mam = new int[len][2];
		long ina = ((long)((maxx-minx))*(long)((maxy-miny)));
		Arrays.sort(points);
		mim[0][0]=points[0].y;
		mim[len-1][1]=points[len-1].y;
		mam[0][0]=points[0].y;
		mam[len-1][1]=points[len-1].y;
		for(int i=1; i<len; i++) {
			mim[i][0] = min(mim[i-1][0], points[i].y);
			mam[i][0] = max(mam[i-1][0], points[i].y);
		}
		for(int i=len-2; i>=0; i--) {
			mim[i][1]=min(mim[i+1][1], points[i].y);
			mam[i][1]=max(mam[i+1][1], points[i].y);
		}
		Arrays.sort(points);
		mim[0][0]=points[0].y;
		mim[len-1][1]=points[len-1].y;
		mam[0][0]=points[0].y;
		mam[len-1][1]=points[len-1].y;
		for(int i=1; i<len; i++) {
			mim[i][0] = min(mim[i-1][0], points[i].y);
			mam[i][0] = max(mam[i-1][0], points[i].y);
		}
		for(int i=len-2; i>=0; i--) {
			mim[i][1]=min(mim[i+1][1], points[i].y);
			mam[i][1]=max(mam[i+1][1], points[i].y);
		}
		long ans1 = Long.MAX_VALUE;
		for(int j=0; j<len-1; j++) {
			int r = points[j].x;
			int l2 = points[j+1].x;
			if(r==l2) {
				continue;
			}
			int l = points[0].x;
			int r2 = points[len-1].x;
			
			long xdifl = r-l;
			long xdifr = r2-l2;
			
			long ydifl = mam[j][0]-mim[j][0];
			long ydifr = mam[j+1][1]-mim[j+1][1];
			
			long sarea = xdifl*ydifl+(xdifr*ydifr);
			ans1 = Math.min(ans1, sarea);
		}
		return ina-ans1;
	}
}
