import java.util.*;
import java.io.*;

public class Main {

    static int N, M, D, ans;
    static int[][] map, copyMap;
    static int[] picked;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }

        ans = 0;
        pick(0, 0, new int[3]);

        System.out.println(ans);
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    static void pick(int cnt, int start, int[] shooter) {
        if (cnt == 3) {
            init();
            attack(shooter);
            return;
        }
        for (int i = start; i < M; i++) {
            shooter[cnt] = i;
            pick(cnt + 1, i + 1, shooter);
        }
    }

    static void attack(int[] shooter) {
        int res = 0;

        for (int n = 0; n < N; n++) {
            visited = new boolean[N][M];
            List<int[]> targets = new ArrayList<>();

            for (int k = 0; k < shooter.length; k++) {
                int targetX = -1, targetY = -1;
                int minDis = Integer.MAX_VALUE;

                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 1) {
                            int dis = distance(i, j, N, shooter[k]);
                            if (dis <= D) {
                                if (dis < minDis || (dis == minDis && j < targetY)) {
                                    minDis = dis;
                                    targetX = i;
                                    targetY = j;
                                }
                            }
                        }
                    }
                }

                if (targetX != -1 && targetY != -1) {
                    targets.add(new int[]{targetX, targetY});
                }
            }

            for (int[] t : targets) {
                if (!visited[t[0]][t[1]]) {
                    visited[t[0]][t[1]] = true;
                    map[t[0]][t[1]] = 0;
                    res++;
                }
            }

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = map[i-1][j];
                }
            }
            Arrays.fill(map[0], 0);
        }

        ans = Math.max(ans, res);
    }

    static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}