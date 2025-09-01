import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. 사람들의 몸무게를 오름차순으로 정렬
        Arrays.sort(people);
        
        int answer = 0;
        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스
        
        // 2. 투 포인터를 사용하여 보트 개수 계산
        while (left <= right) {
            // 가장 가벼운 사람 + 가장 무거운 사람을 한 보트에 태울 수 있는지 확인
            if (people[left] + people[right] <= limit) {
                left++; // 둘 다 태웠으니 다음으로 이동
            }
            // 가장 무거운 사람은 혼자 타든, 가벼운 사람과 타든 무조건 보트 하나를 사용
            right--; // 보트 하나 썼으니 다음 무거운 사람으로 이동
            answer++; // 보트 개수 증가
        }
        
        return answer;
    }
}