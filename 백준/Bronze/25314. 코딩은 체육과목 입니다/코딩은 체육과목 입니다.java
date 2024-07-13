import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String l = "long";
        String i = "int";
        String result = "";
        for (int j = 0; j < n/4; j++) {
            result += l + " ";
        }
        System.out.println(result + i);
    }
}