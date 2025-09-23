import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 대소문자 구분 안함 -> 소문자로 통일시켜주기
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        Queue<String> q = new LinkedList<>();
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        for(int i = 0 ; i < cities.length; i++) {
            if(q.size() == cacheSize) {
                if(q.remove(cities[i])) {
                    answer += 1;
                }
                else {
                    answer += 5;
                    q.poll();
                }
                q.add(cities[i]);
                
            }
            else {
                if(q.remove(cities[i])) {
                    answer += 1;
                }
                else {
                    answer += 5;
                }
                q.add(cities[i]);
            }
            
        }
        return answer;
    }
}