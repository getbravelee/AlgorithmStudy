class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 2;
        while(n > i) {
            if(n % i == 1) { 
                answer = i;
                break;
            }
            i++;
        }
        return answer;
    }
}