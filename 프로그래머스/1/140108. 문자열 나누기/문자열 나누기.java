class Solution {
    public int solution(String s) {
        int answer = 0;
        int same_count = 0;
        int other_count = 0;
        char x = ' ';
        for(int i = 0; i < s.length(); i++) {
            // 새로운 덩어리 시작
            if(same_count == 0 && other_count == 0) {
                x = s.charAt(i);
                answer++;
            }
            if(s.charAt(i) == x) {
                same_count++;
            }
            else {
                other_count++;
            }
            // 카운트 초기화
            if(same_count == other_count) {
                same_count = 0;
                other_count = 0;
            }
        }
        return answer;
    }
}