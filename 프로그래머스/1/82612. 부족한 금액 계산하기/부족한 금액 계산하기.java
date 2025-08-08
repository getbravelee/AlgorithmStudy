class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1; i <= count; i++) {
            sum += (long)price * i;
        }
        if(sum <= money) return 0;
        answer = Math.abs(sum - money);
        return answer;
    }
}