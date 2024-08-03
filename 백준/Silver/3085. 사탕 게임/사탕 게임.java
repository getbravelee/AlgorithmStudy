import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j + 1 < n && !arr[i][j].equals(arr[i][j + 1])) {
                    swap(arr, i, j, i, j + 1);
                    result = Math.max(check(arr), result);
                    swap(arr, i, j, i, j + 1);
                }

                if (i + 1 < n && !arr[i][j].equals(arr[i + 1][j])) {
                    swap(arr, i, j, i + 1, j);
                    result = Math.max(check(arr), result);
                    swap(arr, i, j, i + 1, j);
                }
            }
        }
        System.out.println(result);
    }

    public static void swap(String[][] arr, int i1, int j1, int i2, int j2) {
        String tmp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tmp;
    }

    public static int check(String[][] arr) {
        int maxCnt = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;

            // 가로 비교
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j].equals(arr[i][j + 1])) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(cnt, maxCnt);
            }
            
            cnt = 1; // 초기화
            
            // 세로 비교
            for (int j = 0; j < n - 1; j++) {
                // 가로 비교
                if (arr[j][i].equals(arr[j + 1][i])) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(cnt, maxCnt);
            }
        }
        return maxCnt;
    }
}