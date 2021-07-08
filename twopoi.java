
/*
ID: grifync1
LANG: JAVA
PROG: twopoi
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class twopoi {
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
		//BufferedReader in = new BufferedReader(new FileReader("twopoi.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("twopoi.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int tar = conv(st.nextToken());
		int[] nums = new int[n];st = new StringTokenizer(in.readLine());
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<n; i++) {
			nums[i]=conv(st.nextToken());
			if(map.containsKey(nums[i])) {
				List<Integer> l = map.get(nums[i]);
				l.add(i);
				map.put(nums[i], l);
			}
			else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(nums[i], l);
			}
		}
		boolean c = false;
		for(int i=0; i<n; i++) {
			int want = (tar-nums[i]);
			if(map.containsKey(want)) {
				boolean g = false;
				int ind = 0;
				for(int j: map.get(want)) {
					if(j<i) {
						g=!g;
						ind = j;
						break;
					}
				}
				if(g) {
	 				out.println((ind+1)+" "+(i+1));
					c=!c;
					break;
				}
				else {
					continue;
				}
			}
		}
		if(!c) {
			out.println("IMPOSSIBLE");
		}
		in.close();
		out.close();
	}

}
