import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        // 섞은 = 가장 안 매운 + 그다음 덜 매운*2 -> 순서가 있음 -> 정렬
        // 모든 음식 K 이상 맵게
        // 그럼 섞은 음식은 어디에 넣을래? 정렬이 되어있어야 하는데 -> 우선순위 큐
        // 큐에서 앞에꺼 계속 k이상인지 판단하기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for(int n : scoville) {
            pq.add(n);
        }
        while(pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b*2);
            cnt++;
        }
        if(pq.size() == 1 && pq.peek() < K) {
            return -1;
        } 
        return cnt;
    }
}