import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        int cnt = 1;
        while(true) {
            int n = Integer.parseInt(sb.toString());
            if (n < Integer.parseInt(a)) {
                System.out.println(-1);
                break;
            }
            else if (sb.toString().equals(a)) {
                System.out.println(cnt);
                break;
            } else if (n % 2 != 0) {
                // 마지막 숫자 1
                if (sb.charAt(sb.length()-1) - '0' == 1) {
                    sb.deleteCharAt(sb.length()-1);
                    cnt++;
                    continue;
                // 1외의 홀수
                } else {
                    System.out.println(-1);
                    break;
                }
                // 짝수
            } else {
                n /= 2;
                cnt++;
                sb = new StringBuilder(String.valueOf(n));
            }

        }
    }
}