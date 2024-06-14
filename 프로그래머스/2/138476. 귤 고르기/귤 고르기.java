/*
tangerine을 map으로 최대 값을 찾는다. 
조건1) 최대 값이 k보다 크거나 같은가 -> 카운트 ++ 해서 리턴
조건2) 그렇지 않다면 k - 최대값으로 k의 값을 초기화 하고, 그 뺀 값만큼 해당하는 크기의 과일의 값을 뺀다.
그리고 다시 조건1 부터 반복해서 카운트한다.
*/
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            int fruit = tangerine[i];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }
        // 최대 값 찾기
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        for(int v : list) {
            if(k <= v) {
                answer++;
                break;
            }
            else {
                k -= v;
                answer++;
            }
        }
        return answer;
    }
}