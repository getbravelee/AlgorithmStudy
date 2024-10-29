import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];
        int size = graph.length;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1; // 단방향 그래프
        }

        for (int k = 1; k < size; k++) {
            for (int i = 1; i < size; i++) {
                for (int j = 1; j < size; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < size; i++) {
            int cnt = 0;
            for (int j = 1; j < size; j++) {
                // 자기 자신 제외
                // 양쪽 다 비교가 불가능해야 함
                if(i != j && graph[i][j] == 0 && graph[j][i] == 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
