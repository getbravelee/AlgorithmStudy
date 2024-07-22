import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // list에 동전 종류 초기화
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            // k보다 큰 동전은 의미가 없음
            if (money > k) {
                break;
            }
            list.add(money);
        }
        // 큰 동전부터 비교하려고 편의상 역순 정렬
        list.sort(Collections.reverseOrder());
        // 최솟값 로직
        int sum = 0; // 동전 갯수
        for (int i = 0; i < list.size(); i++) {
            int coin = list.get(i);
            int cnt = k / coin;
            k -= coin * cnt;
            sum += cnt;
        }
        System.out.println(sum);
    }
}