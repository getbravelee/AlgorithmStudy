import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 등수 매핑: 맞춘 갯수가 인덱스

        // 당첨 번호를 HashSet에 넣어 중복 확인을 빠르게 한다
        HashSet<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        int matchCount = 0;
        int zeroCount = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matchCount++;
            }
        }

        // 최저 등수: 맞춘 갯수만 반영
        answer[1] = rank[matchCount];
        // 최고 등수: 맞춘 갯수 + 0의 갯수 반영
        answer[0] = rank[matchCount + zeroCount];

        return answer;
    }
}
