import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[][] graph;
	static int k;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 입력 받을 정수 개수
		k = Integer.parseInt(br.readLine());

		// 연결된 컴퓨터 쌍 수
		c = Integer.parseInt(br.readLine());

		// 그래프
		graph = new int[k + 1][k + 1];
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			graph[n][m] = 1;
			graph[m][n] = 1;

		}

		// 연결 개수
		int cnt = 0;

		// 방문(1번과 연결되어 있다)
		visited = new boolean[k + 1];
		dfs(1);
		for (boolean b : visited) {
			if (b) {
				cnt++;
			}
		}
		// 1번 컴퓨터는 방문 빼준다.
		System.out.println(cnt-1);
	}

	public static void dfs(int n) {
		visited[n] = true;

		for (int i = 1; i <= k; i++) {
			// 방문한 곳은 패스
			if (graph[n][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
	}
}