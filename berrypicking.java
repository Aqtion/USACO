
/*
ID: grifync1
LANG: JAVA
PROG: berrypicking
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class berrypicking {
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
		//BufferedReader in = new BufferedReader(new FileReader("berries.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = conv(st.nextToken());
		int k = conv(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] trees = new int[n];
		for(int i=0; i<n; i++) {
			trees[i]=conv(st.nextToken());
		}
		sort(trees);
		
		int maxsum = -1;
		for(int i=trees[trees.length-1]; i>=1; i--) {
			List<Integer> changed = new ArrayList<Integer>();
			for(int j=0; j<trees.length; j++) {
				if(trees[j]>i) {
					int div = (int)(Math.ceil((double)((double)(trees[j])/(double)(i))));
					int mod = trees[j];
					while(div>0) {
						changed.add(mod/div);
						mod-=(mod/div);
						div--;
					}
				}
				else {
					changed.add(trees[j]);
				}
			}
	
			Collections.sort(changed);
			int sum = 0;
			for(int p=changed.size()-(k/2)-1; p>=max(changed.size()-k,0); p--) {
				sum+=changed.get(p);
			}
		
			maxsum = max(maxsum, sum);
		}
		
		out.println(maxsum);
		in.close();
		out.close();
	}

}
