import java.io.*;
import java.util.*;

public class Main {
    static int x, y, d;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서 순서로 설정
    static int[] dy = {0, 1, 0, -1}; // 북동남서 순서로 설정
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine()); // 둘째 줄 입력
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int v;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    visited[i][j] = true; // 벽 방문처리
                }
                map[i][j] = v;
            }
        }
        cnt = 1;
        visited[x][y] = true;
        robot(x, y, d);
        System.out.println(cnt);
    }

    static void robot(int x, int y, int dir) {
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 방향으로 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true; // 청소
                cnt++;
                robot(nx, ny, dir);
                return; // 재귀 호출 후 리턴
            }
        }

        // 네 방향 모두 청소가 되어 있거나 벽일 경우
        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];

        if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != 1) {
            robot(bx, by, dir); // 후진
        }
        // 아니면 종료
    }
}