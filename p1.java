
/*
ID: grifync1
LANG: JAVA
PROG: whatbase
*/

//lil lil peezy
import java.util.*;
import java.io.*;

public class p1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//StringTokenizer st = new StringTokenizer(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] an = new int[n];
		for(int i=0; i<n; i++) {
			an[i]=Integer.parseInt(in.readLine());
		}
		Arrays.sort(an);
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j==i)
					continue;
				else {
					if(an[i]-an[j]<12 && an[i]-an[j]>0) {
						if(map.containsKey(an[i])) {
							List<Integer> l = map.get(an[i]);
							l.add(an[j]);
							map.put(an[i], l);
						}
						else {
							List<Integer> l = new ArrayList<Integer>();
							l.add(an[j]);
							map.put(an[i], l);
						}
						
					}
				}
			}
		}
		int ans = 0;
		for(int i: an) {
			if(!map.containsKey(i)) {
				ans+=12;
			}
		}
		Map<Integer, Integer> sco = new HashMap<Integer, Integer>();
		for(Integer key: map.keySet()) {
			List<Integer> l = map.get(key);
			Collections.sort(l);
			if(!sco.containsKey(l.get(0))) {
				int c = (int) ((key)-(Math.floor(l.get(0)/12)*12));
				if(c<12) {
					c=12;
				}
				else {
					c=(int) (12*(Math.ceil(c/12)));
				}
				ans+=c;
				sco.put(l.get(0), c);
			}
			else {
				int c = (int) ((key)-(Math.floor(l.get(0)/12)*12));
				if(c<12) {
					c=12;
				}
				else {
					c=(int) (12*(Math.ceil(c/12)));
				}
				if(sco.get(l.get(0))>c) {
					sco.put(l.get(0), c);
					ans-=sco.get(l.get(0));
					ans+=c;
				}
				else {
					continue;
				}
			}
		}
		out.println(ans);
		in.close();
		out.close();
		}
		
	}


