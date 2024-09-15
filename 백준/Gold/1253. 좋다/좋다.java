import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열을 정렬합니다.
        int count = 0;

        // 각 수에 대해 두 수의 합으로 나타낼 수 있는지 확인
        for (int k = 0; k < N; k++) {
            int target = arr[k];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == k) {
                    left++;
                    continue;
                }
                if (right == k) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if (sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}