import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int n2 = n*2;
            int cnt = 0;
            for(int i = n+1; i <= n2; i++) {
                if(isPrimeNum(i)) cnt++;
            }
            System.out.println(cnt);
        }
    }
    public static boolean isPrimeNum(int num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i*i <= num; i += 2) {
            if(num % i == 0) return false;
        }
        return true;
    }
}