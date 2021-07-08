
/*
ID: grifync1
LANG: JAVA
PROG: apartments
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class apartments {
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
		//BufferedReader in = new BufferedReader(new FileReader("apartments.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("apartments.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int m = conv(st.nextToken());
		int k = conv(st.nextToken());
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int a = conv(st.nextToken());
			tm.put(a, tm.getOrDefault(a, 0)+1);
		}
		st = new StringTokenizer(in.readLine());
		int ans = 0;
		for(int i=0; i<m; i++) {
			int a = conv(st.nextToken());
			if(tm.containsKey(a)) {
				int cnt = tm.get(a);
				if(cnt==1) {
					tm.remove(a);
				}
				else {
					tm.put(a, cnt-1);
				}
				ans++;
			}
			else if(tm.higherKey(a)!=null) {
				
				if(a+k>=tm.higherKey(a)) {
					int cnt = tm.get(tm.higherKey(a));
					if(cnt==1) {
						tm.remove(tm.higherKey(a));
					}
					else {
						tm.put(tm.higherKey(a), cnt-1);
					}
					ans++;
				}
			
			}
			if(tm.lowerKey(a)!=null && tm.lowerKey(a)+k>=a) {
				int cnt = tm.get(tm.lowerKey(a));
				if(cnt==1) {
					tm.remove(tm.lowerKey(a));
				}
				else {
					tm.put(tm.lowerKey(a), cnt-1);
				}
				ans++;
			}
			
		}
		out.println(ans);
		in.close();
		out.close();
	}
	
}
