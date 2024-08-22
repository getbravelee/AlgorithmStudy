
import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T =  Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N*N+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int resX = 0;
            int resY = 0;
            int resNum = 0;
            int maxCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = dfs(i, j);

                    if(maxCnt < value) {
                        resX = i;
                        resY = j;
                        resNum = map[resX][resY];
                        maxCnt = value;
                    } else if (maxCnt == value) {
                        if (resNum > map[i][j]) {
                            resX = i;
                            resY = j;
                            resNum = map[resX][resY];
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(resNum).append(" ").append(maxCnt).append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int x, int y) {
        visited[map[x][y]] = true;
        int maxCnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[map[nx][ny]] && Math.abs(map[x][y] - map[nx][ny]) == 1) {
                int res = dfs(nx, ny);
                maxCnt = Math.max(maxCnt, res + 1);
            }

        }
        visited[map[x][y]] = false;
        return maxCnt;
    }
}