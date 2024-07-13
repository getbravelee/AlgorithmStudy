import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.println(result);
    }
}