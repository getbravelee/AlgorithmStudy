import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			// -1 입력되면 종료
			if(n == -1) {
				break;
			}
			// 완전수 판단
			int sum = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 1; i <= n/2; i++) {
				if(n % i == 0) {
					sum += i;
					list.add(i);
				}
				
			}
			if(sum == n) {
				String s = "" + n + " = ";
				for(int j = 0; j < list.size(); j++) {
					s += list.get(j);
					if(j == list.size()-1) {
						break;
					}
					s += " + ";
				}
				System.out.println(s);
			}
			else {
				String s = "" + n + " is NOT perfect.";
				System.out.println(s);
			}
		}
	}
}