class Solution {
    public long solution(long n) {
        long answer = 0;
        if((int)Math.sqrt(n) == Math.sqrt(n)) {
            int temp = (int) Math.sqrt(n);
            answer = (long) Math.pow(temp+1, 2);
        }
        else {
            return -1;
        }
        return answer; 
    }
}