import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int left = 1; // 최소 거리
        int right = home[N-1] - home[0]; // 최대 거리
        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canInstall(home, N, C, mid)) {
                res = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
    static boolean canInstall(int[] home, int N, int C, int mid) {
        int cnt = 1; // 첫번째 집 설치
        int lastInstalled = home[0];
        for (int i = 1; i < N; i++) {
            if (home[i] - lastInstalled >= mid) {
                cnt++;
                lastInstalled = home[i];
            }
        }
        return cnt >= C;
    }
}
