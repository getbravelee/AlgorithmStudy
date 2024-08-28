import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static final int R = 12;
    static final int C = 6;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[R][C];
        visited = new boolean[R][C];
        int res = 0;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        boolean isEnd = true;
        while (isEnd) {
            Queue<Point> q = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] != '.') {
                        if (isClear(i, j)) {
                            q.offer(new Point(i, j));
                        }
                    }
                }
            }
            if(q.isEmpty()) isEnd = false;
            else {
                res++;
                while (!q.isEmpty()) {
                    Point tmp = q.poll();
                    deleteBrick(tmp.x, tmp.y);
                }
            }
            downBrick();

        }
        System.out.println(res);
    }

    public static boolean isClear(int x, int y) {
        char c = map[x][y];
        int cnt = 1;

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[R][C];
        visited[x][y] = true;
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] == c) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        if (cnt >= 4) {
            return true;
        }
        return false;
    }

    // 벽돌 깨기
    public static void deleteBrick(int x, int y) {
        char c = map[x][y];

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[R][C];
        visited[x][y] = true;
        q.offer(new Point(x, y));
        map[x][y] = '.';

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] == c) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 벽돌 내리기
    public static void downBrick() {
        Queue<Character> q = new LinkedList<>();

        for (int j = 0; j < C; j++) {
            for (int i = R-1; i >= 0; i--) {
                if(map[i][j] != '.') q.offer(map[i][j]);
            }
            for (int i = R-1; i >= 0; i--) {
                if(!q.isEmpty()) map[i][j] = q.poll();
                else map[i][j] = '.';
            }
        }
    }
}