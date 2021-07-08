/*
ID: grifync1
LANG: JAVA
PROG: acowdemiaIIIbronze
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class acowdemiaIIIbronze {
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
		//BufferedReader in = new BufferedReader(new FileReader("acowdemiaIIIbronze.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("acowdemiaIIIbronze.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r  = conv(st.nextToken());
		int c = conv(st.nextToken());
		int[][] grid = new int[r][c];
		int[][] dir = new int[][] {{0, 1}, {1,0}, {-1,0}, {0,-1}};
		for(int i=0; i<r; i++) {
			String s = in.readLine();
			for(int j=0; j<c; j++) {
				if(s.charAt(j)=='.') {
					grid[i][j]=0;
				}
				else if(s.charAt(j)=='C') {
					grid[i][j]=1;
				}
				else {
					grid[i][j]=2;
				}
			}
		}
		int ans = 0;
		Set<Long> set = new HashSet<Long>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j]==2) {
					List<cow> cows = new ArrayList<cow>();
					for(int k=0; k<4; k++) {
						int newx = i+dir[k][0];
						int newy = j+dir[k][1];
						if(newx>=0 && newx<r && newy>=0 && newy<c && grid[newx][newy]==1) {
							cows.add(new cow(newx, newy));
						}
					}
					if(cows.size()>2) {
						ans++;
						continue;
					}
					if(cows.size()==2) {
						long one = 1*cows.get(0).x+1000*cows.get(0).y+(1000000L*cows.get(1).x)+(1000000000000L*cows.get(1).y);
						long two = 1*cows.get(1).x+1000*cows.get(1).y+(1000000L*cows.get(0).x)+(1000000000000L*cows.get(0).y);
						if(set.contains(one) || set.contains(two)) {
							continue;
						}
						set.add(one);
						set.add(two);
						//ans++;
					}
				}
				
			}
		}
//		for(int i=0; i<r-1; i++) {
//			for(int j=0; j<c-1; j++)  {
//				if(grid[i][j]==1 && grid[i+1][j+1]==1 && grid[i][j+1]==2 && grid[i+1][j]==2) {
//					ans--;
//				}
//				else if((grid[i][j]==2 && grid[i+1][j+1]==2 && grid[i][j+1]==1 && grid[i+1][j]==1)) {
//					ans--;
//				}
//			}
//		}
		out.println(ans+(set.size()/2));
		in.close();
		out.close();
	}
	static class pair {
		cow c,  c1;
		public pair(cow a, cow b) {
			this.c=a;
			this.c1=b;
		}
	}
	static class cow implements Comparable<cow>{
		int x, y;
		public cow(int a, int b) {
			this.x=a;
			this.y=b;
		}
		
		@Override
		public int compareTo(cow o) {
			return this.x-o.x;
		}
	}
}
