/*
조합
의상 없는 경우 고려해서 종류+1 해줘야 함.
예제1) 2, 1 -> 3, 2 => 3 * 2 - 1(모든 의상 안 입는 경우) = 5
*/
import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();       
        int answer = 1;
        // 의상 종류 별 갯수 초기화
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
        }
        
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1); // 안 입는 경우 + 1
        }
        // 모두 안 입는 경우
        answer -= 1;
        
        return answer;
    }
}