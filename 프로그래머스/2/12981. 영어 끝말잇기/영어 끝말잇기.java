import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {        
        char last = words[0].charAt(0);
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);
        // 1. 한글자 단어 말한 경우
            if(words[i].length() == 1) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
        // 2. 앞 사람이 말한 끝 글자와 현재 첫 글자가 다른 경우
            if(last != first) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
        // 3. 이전에 등장했던 단어의 경우
            if(set.contains(words[i])) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
        // 통과한 경우
            last = words[i].charAt(words[i].length()-1);
            set.add(words[i]);
            
        }
        // 모두 다 돌았다면
        return new int[]{0, 0};
    }
}