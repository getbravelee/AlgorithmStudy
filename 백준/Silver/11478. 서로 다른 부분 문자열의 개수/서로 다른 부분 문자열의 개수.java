import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<String> list = new ArrayList<>();
		String[] s = br.readLine().split("");
		for(int i = 0; i < s.length; i++) {
			String str = s[i];
			list.add(str);
			for(int j = i+1; j < s.length; j++) {
				str += s[j];
				list.add(str);
			}
		}
		Set<String> set = new HashSet<>(list);
		System.out.println(set.size());
	}
}
