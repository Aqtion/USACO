/*
ID: grifync1
LANG: JAVA
PROG: comfcows
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class comfcows {
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
		//BufferedReader in = new BufferedReader(new FileReader("comfcows.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comfcows.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[][] grid = new int[3000][3000];
		int ans = 0;
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = conv(st.nextToken())+500;
			int y = conv(st.nextToken())+500;
			if(grid[x][y]==1) {
				ans--;
				out.println(ans);
				continue;
				
			}
			grid[x][y]=1;
			ans = check(grid, x, y, ans);
			ans = check(grid, x-1, y, ans);
			ans = check(grid, x, y-1, ans);
			ans = check(grid, x+1, y, ans);
			ans = check(grid, x, y+1, ans);
//			for(int[] a: grid) {
//				out.println(Arrays.toString(a));
//			}
			out.println(ans);
		}
		in.close();
		out.close();
	}
	public static int check(int[][] grid, int x, int y, int ans) {
		if(grid[x][y]==0) {
			return ans;
		}
//		if(x==5 && y==2) {
//			System.out.println("salad and pizza ");
//			System.out.println(ans);
//			for(int[] a: grid) {
//				System.out.println(Arrays.toString(a));
//			}
//		}
		if(iscomf(grid, x, y)) {
			ans = addc(grid, x-1, y, ans);
			ans = addc(grid, x, y-1, ans);
			ans = addc(grid, x+1, y, ans);
			ans = addc(grid, x, y+1, ans);
		}
		

		return ans;
	}
	public static boolean iscomf(int[][] grid, int x, int y) {
		if(grid[x-1][y]+grid[x][y-1]+grid[x+1][y]+grid[x][y+1]==3) {
			return true;
		}
		return false;
	}
	public static int addc(int[][] grid, int x, int y, int ans) {
		if(grid[x][y]==1) {
			return ans;
		}
		else {
			grid[x][y]=1;
			ans++;
			ans = check(grid, x, y, ans);
			ans = check(grid, x-1, y, ans);
			ans = check(grid, x, y-1, ans);
			ans = check(grid, x+1, y, ans);
			ans = check(grid, x, y+1, ans);
		}
		return ans;
	}
}
