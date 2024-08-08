import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] isUsed;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isUsed = new boolean[n + 1];
        func(0, 1);
        System.out.println(sb.toString());
    }

    public static void func(int k, int start) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1, i);
                isUsed[i] = false;
        }
    }
}