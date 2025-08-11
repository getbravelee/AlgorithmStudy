import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] ranks = new int[2];
        List<Integer> list = new ArrayList<>();
        // 두 가지 풀이 방법
        // 1. ArrayList에 score 계속 넣고 정렬하고 score길이만큼 계속 반복해서 k순위 값만 result에 넣기
        // 2. k크기 만큼의 ranks 배열 만들어서 k순위 값과 계속 비교하면서 갱신 -> k일이 되기 전까진 최소값이 발표점수이다.
        int min = 2001;
        for(int i = 0; i < score.length; i++) {
            list.add(score[i]);
            if(i < k) {
                if(min < score[i]) {
                    ranks[0] = score[i];
                    ranks[1] = min;
                }
                else {
                    min = score[i];
                    ranks[0] = min;
                    ranks[1] = score[i];
                }
                answer[i] = ranks[1];
            }
            else {
                Collections.sort(list);
                Collections.reverse(list);
                answer[i] = list.get(k-1);
            }
        }
        
        
        return answer;
    }
}