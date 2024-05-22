class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] allNumbers = {0,1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < numbers.length; i++) {
            allNumbers[numbers[i]] = 0;
        }
        for(int i = 0; i < 10; i++) {
            answer += allNumbers[i];
        }
        return answer;
    }
}