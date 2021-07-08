
/*
ID: grifync1
LANG: JAVA
PROG: holstein
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class holstein {
	static List<Integer> ans = new ArrayList<Integer>();
	static int cnt = Integer.MAX_VALUE;
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
		BufferedReader in = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] vitamins = new int[len];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<len; i++) {
			vitamins[i] = conv(st.nextToken());
		}
		int feeds = conv(in.readLine());
		int[][] feed = new int[feeds][len];
		for(int i=0; i<feeds; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<len; j++) {
				feed[i][j] = conv(st.nextToken());
			}
		}
		int[] curamt = new int[len];
		recurse(0, feed, vitamins, curamt, new ArrayList<Integer>());
		out.print(cnt+" ");
		int cnt = 0;
		for(int i: ans) {
			if(cnt==ans.size()-1) {
				out.println(i);
			}
			else {
				out.print(i+" ");
				cnt++;
			}
		}
		in.close();
		out.close();
	}
	public static void recurse(int index, int[][] feed, int[] vitamins, int[] curamt, List<Integer> track) {
		if(isvalid(curamt, vitamins)) {
			if(track.size()<cnt) {
				cnt = track.size();
				ans = new ArrayList<>(track);
			}
			return;
		}
		for(int i=index; i<feed.length; i++) {
			addvals(curamt, feed[i]);
			track.add(i+1);
			recurse(i+1, feed, vitamins, curamt, track);
			subvals(curamt, feed[i]);
			track.remove(track.size()-1);
		}
	}
	public static boolean isvalid(int[] check, int[] with) {
		for(int i=0; i<check.length; i++) {
			if(check[i]>=with[i]) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	public static int[] addvals(int[] curamt,int[] feed) {
		for(int i=0; i<feed.length; i++) {
			curamt[i]+=feed[i];
		}
		return curamt;
	}
	public static int[] subvals(int[] curamt,int[] feed) {
		for(int i=0; i<feed.length; i++) {
			curamt[i]-=feed[i];
		}
		return curamt;
	}
}
