class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] weeks = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] maxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for(int i = 0; i < a-1; i++) {
            totalDays += maxDays[i];    
        }
        totalDays += b;
        answer = weeks[totalDays % 7];
        return answer;
    }
}
