import java.util.*;
import java.io.*;

public class Solution {

    static boolean[] visited;
    static final int MAX_LEN = 101;
    static int[] depth;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            matrix = new int[MAX_LEN][MAX_LEN];
            visited = new boolean[MAX_LEN];
            depth = new int[MAX_LEN];
            Arrays.fill(depth, Integer.MAX_VALUE);

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N / 2; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                matrix[r][c] = 1;
            }

            dfs(start, 0);

            int maxDepth = 0;
            int result = 0;

            for (int i = 100; i >= 1; i--) {
                if (depth[i] != Integer.MAX_VALUE) {
                    if (depth[i] > maxDepth) {
                        maxDepth = depth[i];
                        result = i;
                    } else if (depth[i] == maxDepth) {
                        result = Math.max(result, i);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int v, int d) {
        if (d >= depth[v]) {
            return;
        }

        depth[v] = d;

        for (int i = 1; i < MAX_LEN; i++) {
            if (matrix[v][i] == 1) {
                dfs(i, d + 1);
            }
        }
    }
}
