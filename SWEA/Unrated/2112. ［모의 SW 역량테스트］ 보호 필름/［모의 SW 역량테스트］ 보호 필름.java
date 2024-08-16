
import java.util.*;
import java.io.*;

public class Solution {
    static int D, W, K;
    static int[][] map;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= TC; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[D][W];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            sb.append('#').append(test_case).append(' ').append(min == Integer.MAX_VALUE ? 0 : min).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(int k, int cnt) {
        if (cnt >= min) // 최소값을 넘어가면 의미 없다!!!!!!!!
            return;

        if (k == D) {
            cute: for (int i = 0; i < W; i++) {
                int same = 1;
                for (int j = 0; j < D-1; j++) {
                    if (map[j][i] == map[j + 1][i]) {
                        same++;
                    } else {
                        same = 1;
                    }

                    if (same >= K) {
                        continue cute;// same == K를 한번이라도 발견하면 다음 열 검사
                    }
                }
                return;// 다 돌았는데 same == K 였던 적이 없는 열이 있다면 불합격
            }
            min = Math.min(min, cnt);
            return;
        }

        int[] tmp = map[k].clone();

        // 투입 안하기
        dfs(k + 1, cnt);

        // A 약품 투입
        Arrays.fill(map[k], 0);
        dfs(k + 1, cnt + 1);

        // B 약품 투입
        Arrays.fill(map[k], 1);
        dfs(k + 1, cnt + 1);

        map[k] = tmp;
    }
}
