import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            long num = Long.parseLong(br.readLine());
            while(!isPrimeNum(num)) {
                num++;
            }
            bw.write(String.valueOf(num) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isPrimeNum(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}