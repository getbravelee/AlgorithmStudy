import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> a = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a.put(st.nextToken(), 1);
		}
		
		Map<String, Integer> b = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			b.put(st.nextToken(), 1);
		}
		
		int cnt = 0;
		for(String s : a.keySet()) {
			if(b.containsKey(s)) {
				cnt++;
			}
		}
		
		System.out.println(n+m-cnt*2);
	}
}
