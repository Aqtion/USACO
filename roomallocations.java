
/*
ID: grifync1
LANG: JAVA
PROG: roomallocations
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class roomallocations {
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
		//BufferedReader in = new BufferedReader(new FileReader("roomallocations.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("roomallocations.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		int len = conv(in.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int[][] twodarray = new int[len][3];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = conv(st.nextToken());
			int b = conv(st.nextToken());
			twodarray[i][0]=a;
			twodarray[i][1]=b;
			twodarray[i][2]=i;
		}
		Arrays.sort(twodarray, (a, b) -> a[0]-b[0]);
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> freeRooms = new LinkedList<>();
		for(int i=0; i<len; i++) {
			int tmp = 0;
			int a = twodarray[i][0];
			int b = twodarray[i][1];
			int index = twodarray[i][2];
			while(!pq.isEmpty() && pq.peek().e < a) {
				Pair pop = pq.poll();
				freeRooms.add(pop.rn);
			}
			if(!freeRooms.isEmpty()) {
				tmp = freeRooms.poll();
				Pair newR = new Pair(b,tmp);
				pq.add(newR);
			}else {
				ans++;
				tmp = ans;
				Pair newR = new Pair(b,ans);
				pq.add(newR);
			}
			map.put(index, tmp);
		}
		out.println(ans);
		for(int i=0; i<len; i++) {
			out.print(map.get(i)+" ");
		}
		in.close();
		out.close();
	}
	static class Pair implements Comparable<Pair>{
		int e, rn;
		public Pair(int a, int b) {
			this.e=a;
			this.rn=b;
		}
		@Override
		public int compareTo(Pair o) {
			return this.e-o.e;
		}
		
	}

}
