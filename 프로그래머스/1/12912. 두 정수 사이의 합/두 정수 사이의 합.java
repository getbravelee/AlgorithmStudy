class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        // a > b 일 때 숫자 치환
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // b > a 일 때 순차적으로 더하기
        for(int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }
}