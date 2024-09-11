import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1, 0};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1, 0};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        bfs(7, 0);
        if (map[0][7] == '1') {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void game() {
        // 벽이 아래로 이동
        for (int i = 7; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = map[i - 1][j];
            }
        }

        // 첫 번째 줄은 빈 공간으로 설정
        for (int j = 0; j < 8; j++) {
            map[0][j] = '.';
        }
    }

    static void bfs(int x, int y) {
        if(map[x][y] == '#') return;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            int size = q.size();
            // 플레이어 이동
            for (int k = 0; k < size; k++) {
                Point p = q.poll();

                for (int i = 0; i < 9; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8 && map[nx][ny] == '.') {
                        if (nx - 1 >= 0 && map[nx - 1][ny] == '#') {
                            continue;
                        }
                        q.offer(new Point(nx, ny));
                        map[nx][ny] = '1';
                    }
                }
            }
            if(map[0][7] == '1') break; // 도착했으면 멈추기
            game();
        }
    }

}