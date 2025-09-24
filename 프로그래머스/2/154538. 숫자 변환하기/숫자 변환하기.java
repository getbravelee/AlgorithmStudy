import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        // 사용가능한 연산
        // y로 만들 수 없다면 -1 return
        // 최소 연산 횟수 구하기.
        // 백트래킹? -> 계속 3가지 치기 해야해서 나중에 시간초과 뜸
        // dp 메모이제이션 | 최단거리(bfs)
        int answer = 10_000_000;
        int INF = 10_000_000;
        int[] dp = new int[y+1];
        Arrays.fill(dp, INF);
        dp[x] = 0;
        for(int i = x; i <= y; i++) {
            if(i + n <= y) dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            if(i * 2 <= y) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            if(i * 3 <= y) dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
        if(dp[y] >= 10_000_000) return -1;
        else {
            return dp[y];
        }
    }
}