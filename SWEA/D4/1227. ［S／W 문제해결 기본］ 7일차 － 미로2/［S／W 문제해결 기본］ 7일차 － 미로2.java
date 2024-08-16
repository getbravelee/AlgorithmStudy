import java.util.*;
import java.io.*;

public class Solution {

    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            String n = br.readLine();

            map = new String[100][100];
            visited = new boolean[100][100];

            for(int i = 0; i < 100; i++) {
                map[i] = br.readLine().split("");
            }

            // 시작지점 찾기
            int a = 0, b = 0;
            loop : for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    if (map[i][j].equals("2")) {
                        a = i;
                        b = j;
                        break loop;
                    }
                }
            }
            if(bfs(a, b)) {
                sb.append("#").append(tc).append(" ").append(1).append("\n");
            }
            else {
                sb.append("#").append(tc).append(" ").append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && !visited[nx][ny] && !map[nx][ny].equals("1")) {
                    if (map[nx][ny].equals("3")) {
                        return true;
                    }
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return false;
    }
}

