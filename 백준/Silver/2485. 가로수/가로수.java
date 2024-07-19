import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] trees = new long[n];
        for(int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(br.readLine());
        }

        long[] gaps = new long[n-1];
        long gcdNum = 0;
        for(int i = 0; i < n-1; i++) {
           gaps[i] = trees[i+1] - trees[i];
            gcdNum = gcd(gcdNum, gaps[i]);
        }

        long[] results = new long[n-1];
        long sum = 0;
        for(int i = 0; i < n-1; i++) {
            results[i] = gaps[i]/gcdNum -1;
            sum += results[i];
        }
        System.out.println(sum);
    }
    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}