import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[i][0] = x;
			graph[i][1] = y;
		}
		// 문제처럼 입력값이 끝나는 시간 순서대로 안들어 올 수 있기 때문에 정렬한다.
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
		//처음 카운트
		int cnt = 1;
		int endT = graph[0][1];
		for (int i = 1; i < n; i++) {
			if (graph[i][0] >= endT) {
				cnt++;
				endT = graph[i][1];
			}
		}
		System.out.println(cnt);
	}
}