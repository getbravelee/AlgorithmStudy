class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = 0; i <= right-left; i++) {
            int num = left + i;
            int count = 0;
            for(int j = 1; j <= num; j++) {
                if(num % j == 0) {
                    count++;
                }
            }
            // 갯수가 짝수일 때
            if(count % 2 == 0) {
                answer += num;
            }
            else {
                answer -= num;
            }
        }
        return answer;
    }
}