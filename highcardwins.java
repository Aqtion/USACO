
/*
ID: grifync1
LANG: JAVA
PROG: highcardwins
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class highcardwins {
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
		BufferedReader in = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		boolean[] cards = new boolean[2*len];
		Arrays.fill(cards, false);
		int[] ec = new int[len];
		for(int i=0; i<len; i++) {
			int n = conv(in.readLine());
			cards[n-1]=true;
			ec[i]=n;
		}
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		for(int i=0; i<cards.length; i++) {
			if(!cards[i]) {
				tm.put(i+1, 1);
			}
		}
		int ans = 0;
		for(int i=0; i<len; i++) {
			int a = ec[i];
			
			if(tm.higherKey(a)!=null) {
				if(tm.get(tm.higherKey(a))==1) {
					tm.remove(tm.higherKey(a));
					ans++;
				}
			}
			else {
				continue;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
