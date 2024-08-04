import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            int[] nums = new int[n];
            int[] result = new int[n];

            for(int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }

            Arrays.sort(nums);

            int mid = n / 2;
            result[mid] = nums[n - 1];

            int position = mid;
            for (int i = 1; i < n; i++) {
                if (i % 2 != 0) {
                    position -= i;
                    result[position] = nums[(n - 1) - i];
                } else {
                    position += i;
                    result[position] = nums[(n - 1) - i];
                }
            }

            int maxN = Math.abs(result[0] - result[n - 1]);
            for (int i = 0; i < n - 1; i++) {
                maxN = Math.max(Math.abs(result[i] - result[i + 1]), maxN);
            }
            System.out.println(maxN);
        }
    }
}