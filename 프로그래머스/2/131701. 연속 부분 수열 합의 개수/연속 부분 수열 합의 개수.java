import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        // 시작 인덱스 (i)를 하나씩 옮겨가며 계산
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // 시작 인덱스(i)부터 길이를 1씩 늘려가며 합을 계산
            for (int j = 0; j < n; j++) {
                // 원형 배열이므로 인덱스를 모듈러 연산으로 처리
                currentSum += elements[(i + j) % n];
                sumSet.add(currentSum);
            }
        }
        
        return sumSet.size();
    }
}