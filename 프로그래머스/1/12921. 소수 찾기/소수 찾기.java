class Solution {
    public int solution(int n) {
        int[] divisors = new int[n+1];
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j+=i) {
                divisors[j]++;
            }
        }
        for(int i = 2; i <= n; i++) {
            if(divisors[i] == 2) {
                answer++;
            }
        }
        return answer;
    }
}