/*
일정금액 지불 -> 10일동안 자격부여
매일 한 가지 제품 할인 행사, 할인 제품 하루에 하나 구매 가능
자신이 원하는 제품과 수량이 할인하는 날자와 10일 연속으로 일치할 경우 맞춰서 회원가입 할 것임
discount - 날짜별 할인 제품

map을 사용해서 제품:갯수를 통해 discount를 탐색하면서 10일간 탐색하여 number의 갯수와 일치하는 일수 카운트
*/
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String w : want) {
            map.put(w, 0);
        }
        // discount를 탐색하여 해당하는 key가 있으면 value +1
        for(int i = 0; i <= discount.length-10; i++) {
            Map<String, Integer> currentMap = new HashMap<>(map);
            for(int j = 0; j < 10; j++) {
                String name = discount[i+j];
                if(currentMap.containsKey(name)) {
                    currentMap.put(name, currentMap.get(name) + 1);
                }
            }
            // map과 number의 값을 비교해서 회원가입이 가능할지 판단
            boolean canJoin = true;
            for(int k = 0; k < want.length; k++) {
                if(currentMap.get(want[k]) != number[k]) {
                    canJoin = false;
                    break;
                }
            }

            if(canJoin) {
                answer ++;
            }   
        }
        return answer;
    }
}