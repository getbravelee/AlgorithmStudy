import java.util.*;
import java.io.*;

public class Main {
    static int N,M,cnt;
    static final int[] dx = {1,1,1,0,-1,-1,-1,0};
    static final int[] dy = {-1,0,1,1,1,0,-1,-1};
    static boolean[][] visited;
    static int[][] map;
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            map = new int[N][M];
            visited = new boolean[N][M];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }

            }
        }
    }
}
