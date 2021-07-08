
/*
ID: grifync1
LANG: JAVA
PROG: freetherook
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class freetherook {
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
		//BufferedReader in = new BufferedReader(new FileReader("freetherook.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("freetherook.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());	
		int r = conv(st.nextToken());
		int c = conv(st.nextToken());
		char[][] board = new char[r][c];
		int rx = 0;
		int ry = 0;
		for(int i=0; i<r; i++) {
			String s = in.readLine();
			for(int j=0; j<c; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j]=='R') {
					rx=i;
					ry=j;
				}
			}
		}
		LinkedList<coord> q = new LinkedList<coord>();
		boolean[][] used = new boolean[r][c];
 		q.add(new coord(rx, ry));
		while(!q.isEmpty()) {
			coord prev = q.remove();
			int x = prev.x;
			int y = prev.y;
			while(board[x][y]!='X') {
				if(!used[x][y]) {
					q.add(new coord(x,y));
					used[x][y]=true;
					x++;
					
				}
			}
			x = prev.x;
			y = prev.y;
			while(board[x][y]!='X') {
				if(!used[x][y]) {
					q.add(new coord(x,y));
					used[x][y]=true;
					y++;
					
				}
			}
			x = prev.x;
			y = prev.y;
			while(board[x][y]!='X') {
				if(!used[x][y]) {
					q.add(new coord(x,y));
					used[x][y]=true;
					x--;
					
				}
			}
			x = prev.x;
			y = prev.y;
			while(board[x][y]!='X') {
				if(!used[x][y]) {
					q.add(new coord(x,y));
					used[x][y]=true;
					y--;
					
				}
			}
		}
		in.close();
		out.close();
	}
	static class coord {
		int x, y;
		public coord(int a, int b) {
			this.x=a;
			this.y=b;
		}
	}
	
}
