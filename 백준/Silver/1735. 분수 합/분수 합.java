import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;
        
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int u1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());

            input = br.readLine();
            if (input == null) break; // 추가: 입력이 없으면 반복문 탈출
            st = new StringTokenizer(input);
            int u2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            long u3 = u1 * d2 + u2 * d1;
            long d3 = d1 * d2;

            long gcdValue = gcd(u3, d3);
            u3 /= gcdValue;
            d3 /= gcdValue;

            System.out.println(u3 + " " + d3);
        }
    }
    
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
