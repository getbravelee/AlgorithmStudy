class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if(n == 1) {
            return dp[1];
        }
        else if(n == 2) {
            return dp[2];
        }
        else {
            for(int i = 3; i < 2001; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%1234567;
            }
            answer = dp[n];
            return answer;
        }
        
    }
    
}