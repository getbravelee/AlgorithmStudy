import java.io.*;
import java.util.*;
public class Solution {
    static int[] arr;
    static int N, B;
    static int ans;
    static boolean[] isUsed;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            Arrays.sort(arr);
            isUsed = new boolean[N];
            ans = B;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            func(N - 1, 0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static void func(int k, int sum) {
        if(k == -1) {
            if(B-sum <= 0) {
                ans = Math.min(ans, Math.abs(B-sum));
            }
            return;
        }

        if(B-sum <= 0) {
            ans = Math.min(ans, Math.abs(B-sum));
        }

        else {
            if(!isUsed[k]) {
                func(k-1, sum);
                sum += arr[k];
                isUsed[k] = true;
                func(k-1, sum);
                isUsed[k] = false;
            }
        }
    }
}