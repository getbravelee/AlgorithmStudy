class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 노란색 세로: 갈색 세로 - 2
        // 노란색 가로: 갈색 가로 - 2
        // 가로 세로 조합은 약수이다.
        int total_size = brown + yellow;
        for(int i = 3; i <= total_size; i++) {
            if(total_size % i == 0) {
                int a = i;
                int b = total_size / i;
                if((a-2)*(b-2) == yellow) {
                    answer[0] = Math.max(a, b);
                    answer[1] = Math.min(a, b);
                    break;
                }
            }
        }
        return answer;
    }
}