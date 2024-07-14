import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] result = new int[6];
        for (int i = 0; i < 6; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i < 2 && a != 1) {
                a = 1 - a;
                result[i] = a;
            } else if (i > 1 && i < 5 && a != 2) {
                a = 2 - a;
                result[i] = a;
            } else if (i == 5 && a != 8) {
                a = 8 - a;
                result[i] = a;
            } else {
                result[i] = 0;
            }
        }
        System.out.printf("%d %d %d %d %d %d", result[0], result[1], result[2], result[3], result[4], result[5]);
    }
}