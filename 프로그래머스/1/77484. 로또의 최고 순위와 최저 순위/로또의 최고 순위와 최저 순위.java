class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count = 0;
        int lotto_count = 0;
        int rank = 7;
        for(int num : lottos) {
            if(num == 0) {
                zero_count++;
            }
        }
        for(int i = 0; i < lottos.length; i++) {
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    lotto_count++;
                    rank--;
                }
            }
        }
        

        // 최고 등수
        answer[0] = rank - zero_count;
        if(answer[0] == 7) answer[0] = 6;
        // 최저 등수
        answer[1] = rank;
        if(answer[1] == 7) answer[1] = 6;
        
        return answer;
    }
}