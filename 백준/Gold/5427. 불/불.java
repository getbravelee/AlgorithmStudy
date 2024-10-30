import java.io.*;
import java.util.*;

public class Main {

    static int T,W,H;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0 , 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt;

    static class Point {
        int x, y;
        boolean fire;

        public Point(int x, int y, boolean fire) {
            this.x = x;
            this.y = y;
            this.fire = fire;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];

            int startX = 0, startY = 0;
            Queue<Point> q = new LinkedList<>();
            cnt = 1;
            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '#') {
                        visited[i][j] = true;
                    } else if (map[i][j] == '*') {
                        q.add(new Point(i, j, true)); // 모든 불의 위치를 큐에 추가
                        visited[i][j] = true;
                    } else if (map[i][j] == '@') {
                        startX = i;
                        startY = j;
                    }
                }
            }
            if(startX == 0 || startX == H-1 || startY == 0 || startY == W-1) System.out.println(cnt);
            else if(bfs(startX, startY, q)) System.out.println(cnt);
            else System.out.println("IMPOSSIBLE");
        }
    }

    static boolean bfs(int x, int y, Queue<Point> q) {
        q.add(new Point(x, y, false));  // 상근이
//        visited[x][y] = true;

        while (!q.isEmpty()) {
            // q 사이클 한 번 돌 때 마다 상근이가 한 번 움직일 수 있으므로 카운트
            int size = q.size();
            cnt++;

            for (int k = 0; k < size; k++) {
                Point tmp = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny]) {
                        if (!tmp.fire) { // 상근이가 이동할 때
                            if (nx == 0 || nx == H - 1 || ny == 0 || ny == W - 1) {
                                return true; // 탈출 성공
                            }
                            q.add(new Point(nx, ny, false));
                        } else if (map[nx][ny] == '.' || map[nx][ny] == '@') { // 불이 퍼질 수 있는 곳
                            q.add(new Point(nx, ny, true));
                        }
                        visited[nx][ny] = true;
                    }
                }
            }

        }
        return false;
    }
}
