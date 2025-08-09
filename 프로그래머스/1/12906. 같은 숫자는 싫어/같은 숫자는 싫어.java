import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;
        int beforeNum = -1;
        for(int num : arr) {
            if(beforeNum != num) {
                list.add(num);
                beforeNum = num;
            }
        }
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
            

        return answer;
    }
}