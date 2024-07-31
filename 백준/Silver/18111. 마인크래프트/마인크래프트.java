import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n][m];
		int mx = 0;
		int sum = b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, num);
				sum += num;
				graph[i][j] = num;
			}
		}
		int time = Integer.MAX_VALUE;
		int avg = sum / (n * m);
		int h = 0;
		if (avg >= mx) {
			for (int k = mx; k >= 0; k--) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (graph[i][j] < k) {
							cnt += k - graph[i][j];
						}
						else {
							cnt += 2 * (graph[i][j] - k);
						}
					}
				}
				if(time > cnt) {
					time = cnt;
					h = k;
				}
				else {
					break;
				}
			}
		}
		else {
			for (int k = avg; k >= 0; k--) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (graph[i][j] < k) {
							cnt += k - graph[i][j];
						}
						else {
							cnt += 2 * (graph[i][j] - k);
						}
					}
				}
				if(time > cnt) {
					time = cnt;
					h = k;
				}
				else {
					break;
				}
			}
		}
		System.out.println(time + " " + h);
	}
}