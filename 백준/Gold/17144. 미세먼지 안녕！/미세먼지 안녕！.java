import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map, init;
    static int[] vac;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        init = new int[R][C];
        vac = new int[2];

        int idx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    vac[idx++] = i;  // 청소기 위치 저장
                }
            }
        }

        for (int t = 0; t < T; t++) {
            // 미세먼지 확산
            spread();
            // 공기청정기 작동
            clean();
        }

        // 결과 계산
        System.out.println(getSum());
    }

    private static void spread() {
        for (int i = 0; i < R; i++) {
            System.arraycopy(map[i], 0, init[i], 0, C);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                            init[nx][ny] += amount;
                            count++;
                        }
                    }
                    init[i][j] -= amount * count;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            System.arraycopy(init[i], 0, map[i], 0, C);
        }
    }

    private static void clean() {
        int upper = vac[0];
        int lower = vac[1];

        // 위쪽 공기청정기
        for (int i = upper - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < upper; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[upper][i] = map[upper][i - 1];
        map[upper][1] = 0;

        // 아래쪽 공기청정기
        for (int i = lower + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > lower; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[lower][i] = map[lower][i - 1];
        map[lower][1] = 0;
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}