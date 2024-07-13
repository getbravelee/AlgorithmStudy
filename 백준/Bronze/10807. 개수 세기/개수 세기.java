import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[201];
        for (int i = 0; i < s.length; i++) {
            nums[Integer.parseInt(s[i]) + 100] += 1;
        }
        System.out.println(nums[100+n]);
    }
}