import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];

            int x = 0, y = -1;
            int num = 1, dist = n, distC = 1, cnt = 0;

            while(num <= n*n) {
                if(distC == 2) {
                    dist--;
                    distC = 0;
                }
                for(int j = 0; j < dist; j++) {
                    x = x + dx[cnt%4];
                    y = y + dy[cnt%4];
                    arr[x][y] = num++;
                }
                distC++;
                cnt++;
            }
            sb.append("#" + tc + "\n");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
