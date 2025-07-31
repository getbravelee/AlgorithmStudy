import java.io.*;

class 문제2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 곰젤리 상태 문자열
        int K = Integer.parseInt(br.readLine()); // 시약 범위

        int N = s.length();
        int[] jelly = new int[N]; // 상태를 숫자로 변환
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'Y') jelly[i] = 0;
            else if (c == 'P') jelly[i] = 1;
            else jelly[i] = 2;
        }

        int[] effect = new int[N];  // 각 위치에서 시약을 몇 번 썼는지
        int sumEffect = 0;          // 현재까지 시약 누적 합
        int answer = 0;

        for (int i = 0; i < N; i++) {
            // 슬라이딩 윈도우에서 시약 영향 제거
            if (i >= K) sumEffect -= effect[i - K];

            // 현재 상태 + 누적 영향 = 실제 상태
            int actual = (jelly[i] + sumEffect) % 3;

            // 목표는 I(2) 상태 → 필요한 시약 횟수
            int need = (3 - actual + 2) % 3; // = (2 - actual + 3) % 3

            if (need == 0) continue;

            if (i + K > N) {
                System.out.println(-1); // 범위 벗어나면 불가능
                return;
            }

            // 시약 need번 적용
            effect[i] = need;
            sumEffect += need;
            answer += need;
        }

        System.out.println(answer);
    }
}
