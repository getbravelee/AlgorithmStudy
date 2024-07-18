import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static int n, m;
    static int[] ns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ns = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            ns[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ns);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(BinarySearch(num) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    public static int BinarySearch(int num) {
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int middle = (left+right)/2;
            int middleValue = ns[middle];

            if(num < middleValue) {
                right = middle - 1;
            }
            else if(num > middleValue) {
                left = middle + 1;
            }
            else {
                return 1;
            }
        }
        return 0;
    }
}