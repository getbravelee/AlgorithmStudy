import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int fizz = 0;
		int buzz = 0;
		int fb = 0;
		int num = 0;
		int cnt = 0;
		boolean isNum = false;
		
		for(int i = 0; i < 3; i++) {
			String s = br.readLine();
			try {
				Integer.parseInt(s);
				isNum = true;
			} catch (NumberFormatException e) {
				isNum = false;
			}
			if(isNum) {
				num = Integer.parseInt(s);
				cnt = i;
				break;
			}
			else {
				continue;
			}
		}
		int result = num + (3 - cnt);
		if(result % 3 == 0 && result % 5 != 0) {
			System.out.println("Fizz");
		}
		else if(result % 5 == 0 && result % 3 != 0) {
			System.out.println("Buzz");
		}
		else if(result % 3 == 0 && result % 5 == 0) {
			System.out.println("FizzBuzz");
		}
		else {
			System.out.println(result);
		}
	}
}