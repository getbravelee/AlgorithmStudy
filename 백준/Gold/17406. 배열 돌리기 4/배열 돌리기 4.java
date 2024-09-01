import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[][] operations;
    static boolean[] visited;
    static int[] perm;
    static int[][] copyMap;
    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        operations = new int[K][3];
        visited = new boolean[K];
        perm = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken()) -1;
            operations[i][1] = Integer.parseInt(st.nextToken()) -1;
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        permute(0);

        // 결과 출력
        System.out.println(minSum);
    }

    // 순열 생성 함수
    public static void permute(int depth) {
        if (depth == K) {
            // 순열이 완성되었을 때, 배열 복사 및 회전 수행
            reset();
            for (int i = 0; i < K; i++) {
                int r = operations[perm[i]][0];
                int c = operations[perm[i]][1];
                int s = operations[perm[i]][2];
                rotate(r, c, s, map);
            }
            // 최소 합 갱신
            minSum = Math.min(minSum, sum(map));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = i;
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void rotate(int r, int c, int s, int[][] map) {
        if (s == 0) {
            return;
        }

        int startR = r - s;
        int startC = c - s;
        int endR = r + s;
        int endC = c + s;

        // 원래 위치의 값을 저장
        int temp = map[startR][startC];

        // 아래 -> 위
        for (int i = startR; i < endR; i++) {
            map[i][startC] = map[i + 1][startC];
        }

        // 오 -> 왼
        for (int i = startC; i < endC; i++) {
            map[endR][i] = map[endR][i + 1];
        }

        // 위 -> 아래
        for (int i = endR; i > startR; i--) {
            map[i][endC] = map[i - 1][endC];
        }

        // 왼 -> 오
        for (int i = endC; i > startC; i--) {
            map[startR][i] = map[startR][i - 1];
        }

        // 저장해둔 값을 올바른 위치에 배치
        map[startR][startC + 1] = temp;

        // 다음 레이어로 회전
        rotate(r, c, s-1, map);
    }

    public static int sum(int[][] map) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            res = Math.min(res, sum);
        }
        return res;
    }

    public static void reset() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }
}