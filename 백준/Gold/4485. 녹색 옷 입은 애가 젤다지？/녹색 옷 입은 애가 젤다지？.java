import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] dist;

    static class Point implements Comparable<Point> {
        int x, y, value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE; // 초기 거리 값을 무한대로 설정
                }
            }

            bfs(0, 0);

            System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
            tc++;
        }
    }

    static void bfs(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(x, y, map[x][y]));
        dist[x][y] = map[x][y];

        while (!pq.isEmpty()) {
            Point tmp = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newDist = dist[tmp.x][tmp.y] + map[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        pq.offer(new Point(nx, ny, newDist));
                    }
                }
            }
        }
    }
}