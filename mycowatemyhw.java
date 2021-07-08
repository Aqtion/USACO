
/*
ID: grifync1
LANG: JAVA
PROG: mycowatemyhw
*/

//lil lil peezy
import java.util.*;
import java.io.*;

//me hate u
public class mycowatemyhw {
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
		BufferedReader in = new BufferedReader(new FileReader("homework.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		////BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		///PrintWriter out = new PrintWriter(System.out);
		// StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		int[] nums = new int[len];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < len; i++) {
			nums[i] = conv(st.nextToken());
		}
		long min = 0;
		long rsum = 0;
		float ans = -1;
		// Map<Long, List<Integer>> map = new HashMap<Long, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = len - 1; i > 0; i--) {
			rsum += nums[i];
			if (nums[i] <= min || min==0) {
				rsum = rsum + min - nums[i];
				min = nums[i];
			}
			float soannoying = (float) (rsum) / (float) (len - (i + 1));
			if (ans == soannoying) {
				list.add(i);
			} else if (soannoying > ans) {
				list.clear();
				list.add(i);
				ans = soannoying;
			}

			/*
			 * if(!map.containsKey(soannoying)) { List<Integer> l = new
			 * ArrayList<Integer>(); l.add(i); map.put(soannoying, l); } else {
			 * List<Integer> l = map.get(soannoying); l.add(i); map.put(soannoying, l); }
			 * ans = Math.max(ans, soannoying);
			 */

		}
		// List<Integer> l = map.get(ans);
		Collections.sort(list);
		for (int i : list) {
			out.println(i);
		}
		in.close();
		out.close();
	}

}
