import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] a = new int[n][m];
		int[][] b = new int[n][m];

		// a
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}

		// b
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = s.charAt(j) - '0';
			}
		}
		if(isSame(a,b)) {
			System.out.println(0);
		}
		else {
			if (n < 3 && m < 3) {
				System.out.println(-1);
			} 
			else {
				int cnt = 0;
				// 뒤집기
				for (int i = 0; i < n-2; i++) {
					for (int j = 0; j < m-2; j++) {

						if(a[i][j] != b[i][j]) {
							for(int q = i; q < i+3; q++) {
								for(int w = j; w < j+3; w++) {
									a[q][w] = change(a[q][w]);
								}
							}
							cnt++;
						}
					}
				}
				// 비교
				if(!isSame(a,b)) System.out.println(-1);
				else System.out.println(cnt);
			}
		}
		
	}
	public static int change(int n) {
		if(n == 1) {
			return 0;
		}
		else return 1;
	}
    
    public static boolean isSame(int[][] a, int[][] b) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}