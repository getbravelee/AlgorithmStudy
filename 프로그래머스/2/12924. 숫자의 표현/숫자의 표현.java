class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while(sum <= n) {
                if(sum == n) {
                    answer++;
                    break;
                }
                sum += num++;
            }
        }
        return answer;
    }
}