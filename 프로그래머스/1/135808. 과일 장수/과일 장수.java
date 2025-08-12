import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : score) {
            pq.add(n);
        }
        for(int i = 0; i < score.length / m; i++) {
            int min = 10;
            for(int j = 0; j < m; j++) {
                min = Math.min(min, pq.poll());
            }
            answer += min * m;
        }
        return answer;
    }
}