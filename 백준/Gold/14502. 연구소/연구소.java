import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxSafeArea;

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxSafeArea = 0;
        bt(0);
        System.out.println(maxSafeArea);
    }

    public static void bt(int cnt) {
        if (cnt == 3) {
            maxSafeArea = Math.max(maxSafeArea, getSafeArea());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;  // 벽을 세움
                    bt(cnt + 1);
                    map[i][j] = 0;  // 벽을 다시 허물음
                }
            }
        }
    }

    public static int getSafeArea() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2) {  // 바이러스 위치에서 시작
                    q.offer(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;  // 바이러스 확산
                    q.offer(new Point(nx, ny));
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        return safeArea;
    }
}
