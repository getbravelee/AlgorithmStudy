import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] arr = s.split("");
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                answer[i] = i - map.get(arr[i]);
            }
            else {
                answer[i] = -1;
            }
            map.put(arr[i], i);
        }
        return answer;
    }
}