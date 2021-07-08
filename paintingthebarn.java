
/*
ID: grifync1
LANG: JAVA
PROG: paintingthebarn
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class paintingthebarn {
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
		//BufferedReader in = new BufferedReader(new FileReader("paintbarn.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		long[][] prefix = new long[201][201];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
				int x = conv(st.nextToken())+1;
				int y = conv(st.nextToken())+1;
				int x1 = conv(st.nextToken())+1;
				int y1 = conv(st.nextToken())+1;
				prefix[x][y]+=1;
				prefix[x1][y1]+=1;
				prefix[x][y1]-=1;
				prefix[x1][y]-=1;
		}
		long area = 0;
		for(int i=1; i<=200; i++) {
			for(int j=1; j<=200; j++) {
				prefix[i][j]+=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
				if(prefix[i][j]==k) {
					area++;
				}
			}
		}
		int[][] sss = new int[201][201];
		for(int i=0; i<200; i++) {
			for(int j=0; j<200; j++) {
				if(prefix[i][j]==k-1) {
					sss[i][j]=1;
				}
				else if(prefix[i][j]==k) {
					sss[i][j]=-1;
				}
				else {
					sss[i][j]=0;
				}
				out.print((sss[i][j]+1)+" ");
			}
			out.println();
		}
		
		out.println(area);
		in.close();
		out.close();
	}

}
