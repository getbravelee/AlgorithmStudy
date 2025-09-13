import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++) {
            count.put(discount[i], count.getOrDefault(discount[i], 0) + 1);
        }

        for(int i = 0; i <= discount.length - 10; i++) {
            if(map.equals(count)) {
                answer++;
            }
            if(i + 10 < discount.length) {
                count.put(discount[i], count.get(discount[i]) - 1);
                if(count.get(discount[i]) == 0) {
                    count.remove(discount[i]);
                }
                count.put(discount[i+10], count.getOrDefault(discount[i+10], 0) + 1);
            }
            
        }
        return answer;
    }
}