import java.util.*;
import java.io.*;

public class Solution {


    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static Queue<Cell> q = new LinkedList<>();
    static final short DEATH = 0, ACTIVE = 1, INACTIVE = 2;

    static class Cell {
        int x, y;
        int value, tmp;
        short status;

        Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.tmp = value;
            this.status = INACTIVE;
        }

        void next() {
            switch (status) {
                case INACTIVE: // 비활성화 상태
                    if (--tmp == 0) status = ACTIVE;
                    break;
                case ACTIVE: // 활성화 상태
                    if (++tmp == value) status = DEATH;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[700][700];
            visited = new boolean[700][700];
            q.clear();

            int center = 700 / 2;
            for (int i = center; i < center + N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = center; j < center + M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value != 0) {
                        map[i][j] = value;
                        visited[i][j] = true;
                        q.add(new Cell(i, j, value));
                    }
                }
            }
            int ans = spread();
            String s = "#" + tc + " " + ans;
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    static int spread() {
        while (K-- > 0) {
            int len = q.size();
            for (Cell c : q) {
                if (c.status == ACTIVE) check(c); // 주변 세포 value 설정
            }
            for (int t = 0; t < len; t++) {
                Cell tmp = q.poll();
                if (tmp.status == ACTIVE) { // 활성화 경우에만 번식
                    for (int i = 0; i < 4; i++) {
                        int nx = tmp.x + dx[i];
                        int ny = tmp.y + dy[i];

                        if (visited[nx][ny]) continue;
                        q.add(new Cell(nx, ny, map[nx][ny])); // 번식된 세포 추가
                        visited[nx][ny] = true;
                    }
                }
                tmp.next(); // 상태 변화

                if (tmp.status == DEATH) continue; // 죽은 세포 q에 추가 X
                q.add(tmp);
            }
        }
        return q.size(); // 살아있는 세포 수
    }

    static void check(Cell cell) {
        for (int i = 0; i < 4; i++) {
            int nx = cell.x + dx[i];
            int ny = cell.y + dy[i];

            if (visited[nx][ny]) continue;
            if (map[nx][ny] < cell.value) map[nx][ny] = cell.value;
        }
    }
}
