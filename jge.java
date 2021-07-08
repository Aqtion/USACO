
/*
ID: grifync1
LANG: JAVA
PROG: jge
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class jge {
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
		//BufferedReader in = new BufferedReader(new FileReader("jge.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("jge.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[][] grid = new int[len][len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<len; j++) {
				grid[i][j]=conv(st.nextToken());
			}
		}
		boolean[][][][] isones = new boolean[len][len][len][2];
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				for(int k=j; k<len; k++) {
					if(k==j) {
						isones[i][j][k][0]=grid[i][k]>=100;
						isones[i][j][k][1]=grid[i][k]>100;
					}
					else {
						isones[i][j][k][0]=(grid[i][k]>=100 && isones[i][j][k-1][0]);
						isones[i][j][k][1]=(grid[i][k]>100 && isones[i][j][k-1][1]);
					}
//					isones[i][j][k][0]=true;
//					isones[i][j][k][1]=true;
//					for(int c=j; c<=k; c++) {
//						if(grid[i][c]<100) {
//							isones[i][j][k][0]=false;
//						}
//						if(grid[i][c]<=100) {
//							isones[i][j][k][1]=false;
//						}
//					}
				}
			}
		}
		long total = 0;
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				int tmp = 0;
				for(int r=0; r<len; r++) {
					if(isones[r][i][j][0]) {
						tmp++;
					}
					else {
						total+=((tmp)*(tmp+1))/2;
						tmp=0;
					}
				}
				total+=((tmp)*(tmp+1))/2;
			}
		}
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				int tmp = 0;
				for(int r=0; r<len; r++) {
					if(isones[r][i][j][1]) {
						tmp++;
					}
					else {
						total-=((tmp)*(tmp+1))/2;
						tmp=0;
					}
				}
				total-=((tmp)*(tmp+1))/2;
			}
		}
		out.println(total);
		in.close();
		out.close();
	}

}
