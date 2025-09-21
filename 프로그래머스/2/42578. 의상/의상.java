import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 같은 부위 못 입음, 같은 이름 없음
        // 부위, 갯수 -> hashmap, 독립적
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        for(int n : map.values()) {
            answer *= (n + 1);
        }
        return answer-1;
    }
}