import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> key = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                String s = String.valueOf(c);
                if(key.containsKey(s)) {
                    if(key.get(s) > j) {
                        key.put(s, j);
                    }
                }
                else {
                    key.put(s, j);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                String s = String.valueOf(targets[i].charAt(j));
                if(!key.containsKey(s)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += key.get(s) + 1;
            }
        }
        return answer;
    }
}