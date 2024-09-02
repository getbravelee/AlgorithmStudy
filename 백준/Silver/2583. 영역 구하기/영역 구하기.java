import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int M, N, K, cnt = 0;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[M][N];
        visited = new int[M][N];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    board[i][j] = 1;
                }
            }
        }
        
        PriorityQueue<Integer> w = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && visited[i][j] == 0) {
                    w.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
        int len = w.size();
        for (int i = 0; i < len; i++) {
            System.out.print(w.poll() + " ");
        }
    }
    
    
    public static int bfs(int x, int y) {
        int width = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = 1;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d], ny = pos[1] + dy[d];
                if (0 <= nx && nx < M && 0 <= ny && ny < N && board[nx][ny] == 0 && visited[nx][ny] == 0) {
                    width++;
                    visited[nx][ny] = 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        return width;
    }

}

