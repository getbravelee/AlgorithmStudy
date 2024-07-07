import java.io.*;
import java.util.*;

/**
 *
 */

public class  Solution {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int sum = 0;
            // 그래프 초기화
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // + 모양
            // 방향
            int[] dr = {-1, 1, 0, 0}; // + 모양 행 방향
            int[] dc = {0, 0, -1, 1}; // + 모양 열 방향
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int temp = arr[r][c]; // 중심 셀
                    for (int m = 1; m < M; m++) { // 중심 셀로부터 거리
                        for (int d = 0; d < 4; d++) { // 방향
                            // 다음 행과 열
                            int nr = r + dr[d] * m;
                            int nc = c + dc[d] * m;
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                temp += arr[nr][nc]; // 그래프 안에 있으면 값 더하기
                            }
                        }
                    }
                    if (temp > sum) {
                        sum = temp;
                    }
                }
            }

            // x 모양
            int[] drx = { -1, 1, -1, 1 }; // x 모양 행 방향
            int[] dcx = { -1, 1, 1, -1 }; // x 모양 열 방향
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int tmp = arr[r][c];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nr = r + drx[d] * m;
                            int nc = c + dcx[d] * m;
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                tmp += arr[nr][nc];
                            }
                        }

                    }
                    if (tmp > sum) {
                        sum = tmp;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc + 1, sum);
        }
    }
}