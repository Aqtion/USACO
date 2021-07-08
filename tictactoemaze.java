
/*
ID: grifync1
LANG: JAVA
PROG: tictactoemaze
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class tictactoemaze {
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
		//BufferedReader in = new BufferedReader(new FileReader("tictactoemaze.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tictactoemaze.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		String[][] s = new String[len][len];
		int f = 0;
		int s1 = 0;
		for(int i=0; i<len; i++) {
			String l = in.readLine();
			for(int j=0; j<len; j++) {
				s[i][j]=l.substring(j*3, (j+1)*3);
				if(s[i][j].equals("BBB")) {
					f=i;
					s1=j;
				}
			}
		}
		char[][] gr = new char[3][3];
		for(int i =0; i<3; i++) {for(int j=0; j<3; j++) {gr[i][j]='.';}};
		boolean[][][] vis = new boolean[len][len][19683];
		out.println(dfs(f, s1, gr, s, vis));
		in.close();
		out.close();
	}
	public static int dfs(int r, int c, char[][] g, String[][] a, boolean[][][] vis) {
		for(char[] t: g) {
			System.out.println(Arrays.toString(t));
		}
		
		System.out.println(r+" "+c);
		System.out.println("-------------------");
	
		if(iw(g)) {
			return 1;
		}
		int cnt = 0;
		
		for(int i=0; i<4; i++) {
			int rd = 0;
			int cd = 0;
			if(i==0) {
				rd = -1;
				cd = 0;
			}
			else if(i==1) {
				rd = 0;
				cd = 1;
			}
			else if(i==2) {
				rd=1;
				cd = 0;
			}
			else if(i==3) {
				rd = 0;
				cd = -1;
			}
			//System.out.println("rd: "+rd +" cd:"+cd);
			int nr = r+rd;
			int nc = c+cd;
			if(nr<0 || nr>=a.length || nc<0 || nc>=a.length || (a[nr][nc].equals("###"))) {
				continue;
			}

			if(a[nr][nc].charAt(0)=='O' || a[nr][nc].charAt(0)=='M') {
				g[a[nr][nc].charAt(1)-'1'][a[nr][nc].charAt(2)-'1']=a[nr][nc].charAt(0);
				
			}
			char[][] k = new char[3][3];
			for(int h =0; h<3; h++) {for(int j=0; j<3; j++) {k[h][j]=g[h][j];}};
			if(a[nr][nc].charAt(0)=='O' || a[nr][nc].charAt(0)=='M') {
				k[a[nr][nc].charAt(1)-'1'][a[nr][nc].charAt(2)-'1']=a[nr][nc].charAt(0);
				
			}
			if(!vis[nr][nc][ccti(k)]) {
				vis[nr][nc][ccti(k)]=true;
				cnt+=dfs(nr, nc, k, a, vis);
			}
		}
		vis[r][c][ccti(g)]=false;
		return cnt;
	}
	public static int ccti(char[][] grid) {
	
		int ci = 0;
		int f = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				if(grid[i][j]=='.') {
					f++;
					continue;
				}
				else if(grid[i][j]=='O') {
					ci+=Math.pow(3, f);
				}
				else {
					ci+=2*Math.pow(3, f);
				}
				f++;
			}
		}
		return ci;
		
	}
	public static boolean iw(char[][] g) {
		
		for(int i=0; i<3; i++) {
			if(g[i][0]=='O' && g[i][1]=='O' && g[i][2]=='M') {
				return true;
			}
			else if(g[i][0]=='M' && g[i][1]=='O' && g[i][2]=='O') {
				return true;
			}
		}
		if(g[0][0]=='M' && g[1][1]=='O' && g[2][2]=='O') {
			return true;
		}
		else if(g[0][0]=='O' && g[1][1]=='O' && g[2][2]=='M') {
			return true;
		}
		else if(g[0][2]=='M' && g[1][1]=='O' && g[2][0]=='O') {
			return true;
		}
		else if(g[0][2]=='O' && g[1][1]=='O' && g[2][0]=='M') {
			return true;
		}	
		for(int i=0; i<3; i++) {
			if(g[0][i]=='O' && g[1][i]=='O' && g[2][i]=='M') {
				return true;
			}
			else if(g[0][i]=='M' && g[1][i]=='O' && g[2][i]=='O') {
				return true;
			}
		}
		return false;
	}
}
