import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        long res = Long.MAX_VALUE;
        int h = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1_000_000_000;
        while(left <= right) {
            int mid = (left + right) / 2;
            long result = 0;
            for(int n : tree) {
                int gap = n - mid;
                if(gap > 0) result += gap;
            }
            if(result >= M) {
                if(res >= result) {
                    left = mid + 1;
                    res = result;
                    h = mid;
                }
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(h);
    }
}
