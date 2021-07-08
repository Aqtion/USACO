

/*
ID: grifync1
LANG: JAVA
PROG: usbvsps2
*/

//:O :/ :) :D :(
//lil lil peezy
import java.util.*;
import java.io.*;

public class usbvsps2 {
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
		//BufferedReader in = new BufferedReader(new FileReader("usbvsps2.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("usbvsps2.out")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int usb = conv(st.nextToken());
		int ps2 = conv(st.nextToken());
		int both = conv(st.nextToken());
		int mice = conv(in.readLine());
		List<Integer> usbc = new ArrayList<Integer>();
		List<Integer> ps2c = new ArrayList<Integer>();
		for(int i=0; i<mice; i++) {
			st = new StringTokenizer(in.readLine());
			int c = conv(st.nextToken());
			String s = st.nextToken();
			if(s.equals("PS/2")) {
				ps2c.add(c);
			}
			else {
				usbc.add(c);
			}
 		}
		int comps = 0;
		long tc= 0;
		Collections.sort(usbc);
		Collections.sort(ps2c);
		int ind = 0;
		while(usb>0 && ind<usbc.size()) {
			comps++;
			tc+=usbc.get(ind);
			ind++;
			usb--;
		}
		int ind1 = 0;
		while(ps2>0 && ind1<ps2c.size()) {
			comps++;
			tc+=ps2c.get(ind1);
			ind1++;
			ps2--;
		}
		while((ind<usbc.size() || ind1<ps2c.size()) && both>0) {
			comps++;
			both--;
			
			if(ind==usbc.size()) {
				tc+=ps2c.get(ind1);
				ind1++;
				continue;
			}
			if(ind1==ps2c.size()) {
				
				tc+=usbc.get(ind);
				ind++;
				continue;
			}
			tc+=min(usbc.get(ind) , ps2c.get(ind1));
			if(usbc.get(ind)<ps2c.get(ind1)) {
				ind++;
			}
			else {
				ind1++;
			}
			
			
		}
		out.println(comps+" "+tc);
		in.close();
		out.close();
	}

}
