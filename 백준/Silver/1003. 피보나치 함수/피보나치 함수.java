import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
/*
 * f(0) = 0
 * 1 = 1
 * 2 = f(1) + f(0)
 * 3 = f(2) + f(1) = f(1) + f(0) + f(1) = 2f(1) + f(0)
 * 4 = 3 + 2 = 2f(1) + f(0) + f(1) + f(0) = 3f(1) + 2f(0)
 * 5 = 4 + 3 = 3f(1) + 2f(0) + 2f(1) + f(0) = 5f(1) + 3f(0)
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        // 재귀하면 시간초과 뜸 -> DP
        int[][] fibo = new int[41][2];
        // 초기값
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        for(int i = 2; i < 41; i++) {
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }
        for(int i = 0; i < n; i++) {
            int f = Integer.parseInt(br.readLine());
            System.out.println(fibo[f][0] + " " + fibo[f][1]);
        }

    }
}