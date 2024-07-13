import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < n; i++) {
            String[] items = br.readLine().split(" ");
            int a = Integer.parseInt(items[0]);
            int b = Integer.parseInt(items[1]);

            result += a*b;
        }
        if (result == total) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}