import java.io.*;
import java.util.*;

public class Main {

    static int R,C;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int cnt;

    static class Point {
        int x, y;
        boolean isFire;

        public Point(int x, int y, boolean isFire) {
            this.x = x;
            this.y = y;
            this.isFire = isFire;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        cnt = 1;
        // 지훈이 시작위치
        int x = 0;
        int y = 0;
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                char c = map[i][j];
                if (c == 'J') {
                    x = i;
                    y = j;
                }
                else if (c == '#') {
                    visited[i][j] = true;
                }
                else if (c == 'F') {
                    visited[i][j] = true;
                    q.add(new Point(i, j, true));
                }
            }
        }

        if(x == 0 || x == R-1 || y == 0 || y == C-1) System.out.println(cnt);
        else {
            boolean game = bfs(x, y, q);
            if(!game) System.out.println("IMPOSSIBLE ");
            else System.out.println(cnt);
        }

    }

    static boolean bfs(int x, int y, Queue<Point> q) {
        q.add(new Point(x, y, false));

        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int k = 0; k < size; k++) {
                Point tmp = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                        if (!tmp.isFire) {
                            if (nx == 0 || nx == R - 1 || ny == 0 || ny == C - 1) {
                                return true;
                            }
                            if (map[nx][ny] == '.') {
                                visited[nx][ny] = true;
                                q.add(new Point(nx, ny, false));
                            }
                        }
                        else {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny, true));
                        }

                    }
                }
            }
        }
        return false;
    }
}
