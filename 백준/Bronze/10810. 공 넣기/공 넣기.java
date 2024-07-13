import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] basket = new int[n];
        for(int t = 0; t < m; t++) {
            String[] balls = br.readLine().split(" ");
            int i = Integer.parseInt(balls[0]);
            int j = Integer.parseInt(balls[1]);
            int k = Integer.parseInt(balls[2]);
            for(int a = i-1; a < j; a++) {
                basket[a] = k;
            }
        }
        String result = "";
        for (int i = 0; i < basket.length; i++) {
            if (i == basket.length - 1) {
                result += basket[i];
                break;
            }
            result += basket[i] + " ";
        }
        System.out.println(result);
    }
}