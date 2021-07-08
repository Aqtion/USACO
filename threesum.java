
/*
ID: grifync1
LANG: JAVA
PROG: threesum
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class threesum {
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
		//BufferedReader in = new BufferedReader(new FileReader("threesum.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = conv(st.nextToken());
		int tar = conv(st.nextToken());
		int[] nums = new int[len];
		 st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			nums[i]=conv(st.nextToken());
			map.put(nums[i], i);
		}
		boolean found = false;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(i==j) {
					continue;
				}
				else {
					if(map.containsKey(tar-nums[i]-nums[j]) && !found) {
						if(map.get(tar-nums[i]-nums[j])!=i && map.get(tar-nums[i]-nums[j])!=j) {
							out.println((map.get(tar-nums[i]-nums[j])+1)+" "+(i+1)+" "+(j+1));
							found = true;
							break;
						}
					}
				}
			}
		}
		if(!found) {
			out.println("IMPOSSIBLE");
		}
		in.close();
		out.close();
	}

}
