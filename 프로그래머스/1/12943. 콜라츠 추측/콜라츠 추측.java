class Solution {
    static int answer = 0;
    public int solution(int num) {
        recursion(num);
        return answer;
    }
    private void recursion(long num) {
        if(num == 1) return;
        
        if(answer > 500) {
            answer = -1;
            return;
        }
        answer++;

        // 입력 수 짝수
        if(num % 2 == 0) {
            recursion(num / 2);
        }
        // 입력 수 홀수
        else {
            recursion(num * 3 + 1);
        }
    }
}