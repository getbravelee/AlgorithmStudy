import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int curr = nums[i];
            int idx = Collections.binarySearch(list, curr);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx < list.size()) {
                list.set(idx, curr);
            }
            else {
                list.add(curr);
            }
        }
        System.out.println(list.size());

    }

}
