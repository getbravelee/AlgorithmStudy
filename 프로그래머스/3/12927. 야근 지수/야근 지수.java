import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            reverse_pq.offer(works[i]);
        }
        while(n > 0) {
            int max_num = reverse_pq.poll();
            if(max_num - 1 < 0) {
                max_num = 1;
            }
            reverse_pq.offer(max_num - 1);
            n--;
        }
        while(!reverse_pq.isEmpty()) {
            int value = reverse_pq.poll();
            answer += value * value;
        }
        return answer;
    }
}