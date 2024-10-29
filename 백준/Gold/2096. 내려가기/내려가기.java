import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dpMax = new int[2][3];
        int[][] dpMin = new int[2][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 이전 줄의 값에서 최댓값과 최솟값 갱신
            dpMax[1][0] = a + Math.max(dpMax[0][0], dpMax[0][1]);
            dpMax[1][1] = b + Math.max(dpMax[0][0], Math.max(dpMax[0][1], dpMax[0][2]));
            dpMax[1][2] = c + Math.max(dpMax[0][1], dpMax[0][2]);

            dpMin[1][0] = a + Math.min(dpMin[0][0], dpMin[0][1]);
            dpMin[1][1] = b + Math.min(dpMin[0][0], Math.min(dpMin[0][1], dpMin[0][2]));
            dpMin[1][2] = c + Math.min(dpMin[0][1], dpMin[0][2]);

            // 현재 줄을 이전 줄로 갱신
            for (int j = 0; j < 3; j++) {
                dpMax[0][j] = dpMax[1][j];
                dpMin[0][j] = dpMin[1][j];
            }
        }

        int maxResult = Math.max(dpMax[0][0], Math.max(dpMax[0][1], dpMax[0][2]));
        int minResult = Math.min(dpMin[0][0], Math.min(dpMin[0][1], dpMin[0][2]));

        System.out.println(maxResult + " " + minResult);
    }
}