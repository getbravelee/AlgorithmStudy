import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            switch(str[0]) {
                case "I" :
                    pq.offer(Integer.parseInt(str[1]));
                    reverse_pq.offer(Integer.parseInt(str[1]));
                    break;
                case "D" :
                    if(reverse_pq.size() > 0 && str[1].equals("1")) {
                        int maxNum = reverse_pq.poll();
                        pq.remove(maxNum);
                    }
                    else if(pq.size() > 0 && str[1].equals("-1")) {
                        int minNum = pq.poll();
                        reverse_pq.remove(minNum);
                    }
                    break;
            }
        }
        if(pq.size() > 1) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }
        else if(pq.size() == 1) {
            answer[0] = reverse_pq.poll();
            answer[1] = answer[0];
        }
        return answer;
    }
}