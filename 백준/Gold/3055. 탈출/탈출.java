import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};
    static int sX, sY;
    static List<Water> list = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    static boolean[][] visitedWater; // 물의 방문 처리
    static boolean[][] visitedHedgehog; // 고슴도치의 방문 처리

    static class Water {
        int x, y;

        public Water(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point {
        int x, y, dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedWater = new boolean[R][C];
        visitedHedgehog = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if(c == 'S') {
                    sX = i; sY = j;
                } else if(c == '*') {
                    list.add(new Water(i, j));
                }
            }
        }

        bfs(sX, sY);
        if (ans == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(ans);
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        // 물의 위치를 먼저 큐에 넣고 처리
        for (Water w : list) {
            visitedWater[w.x][w.y] = true;
            q.offer(new Point(w.x, w.y, -1)); // 물의 이동은 거리를 -1로 처리
        }

        // 고슴도치의 위치 큐에 넣고 처리
        q.offer(new Point(x, y, 0));
        visitedHedgehog[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            // 고슴도치가 목적지에 도달했을 때
            if (map[p.x][p.y] == 'D') {
                ans = p.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    // 물이 퍼지는 경우
                    if (p.dist == -1 && !visitedWater[nx][ny] && map[nx][ny] == '.') {
                        visitedWater[nx][ny] = true;
                        q.offer(new Point(nx, ny, -1));
                    }

                    // 고슴도치가 이동하는 경우
                    if (p.dist >= 0 && !visitedHedgehog[nx][ny] && !visitedWater[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
                        visitedHedgehog[nx][ny] = true;
                        q.offer(new Point(nx, ny, p.dist + 1));
                    }
                }
            }
        }
    }
}