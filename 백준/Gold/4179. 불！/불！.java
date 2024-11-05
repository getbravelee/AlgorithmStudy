import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visitedJ, visitedF;
    static Queue<Point> jq = new LinkedList<>();
    static Queue<Point> fq = new LinkedList<>();

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedJ = new boolean[R][C];
        visitedF = new boolean[R][C];
        
        int x = 0, y = 0;

        // 초기 지도 상태 입력 및 불과 지훈 위치 초기화
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'J') {
                    x = i;
                    y = j;
                    visitedJ[i][j] = true;
                    jq.add(new Point(i, j));
                } else if (map[i][j] == 'F') {
                    visitedF[i][j] = true;
                    fq.add(new Point(i, j));
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static int bfs() {
        int time = 0;

        while (!jq.isEmpty()) {
            time++;

            // 먼저 불이 퍼지는 과정
            int fireSize = fq.size();
            for (int f = 0; f < fireSize; f++) {
                Point fire = fq.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visitedF[nx][ny] && map[nx][ny] != '#') {
                        visitedF[nx][ny] = true;
                        fq.add(new Point(nx, ny));
                    }
                }
            }

            // 지훈이가 이동하는 과정
            int jihoonSize = jq.size();
            for (int j = 0; j < jihoonSize; j++) {
                Point jihoon = jq.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = jihoon.x + dx[d];
                    int ny = jihoon.y + dy[d];

                    // 지훈이가 탈출할 수 있는 경우
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        return time;
                    }

                    // 다음 위치가 빈 공간이고 방문하지 않았으며, 불이 아직 도달하지 않은 경우
                    if (!visitedJ[nx][ny] && !visitedF[nx][ny] && map[nx][ny] == '.') {
                        visitedJ[nx][ny] = true;
                        jq.add(new Point(nx, ny));
                    }
                }
            }
        }

        return -1;
    }
}
