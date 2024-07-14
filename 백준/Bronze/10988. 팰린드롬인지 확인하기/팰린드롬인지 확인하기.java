import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        if (s.equals(reverse)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}