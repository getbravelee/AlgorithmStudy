import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp(n));
		}
	}
	
	public static int dp(int n) {
		if(n == 1) return 1;
		else if(n==2) return 2;
		else if(n==3) return 4;

		return dp(n-1)+dp(n-2)+dp(n-3);
		
	}
}