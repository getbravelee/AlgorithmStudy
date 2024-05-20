import java.util.*;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        // 문자열로 바꾸기
        String s = "" + n;
        // 내림차순 정렬하여 문자열로 초기화할 변수
        String revSortedList = "";
        // 원소 크기를 비교하여 오름차순 정렬하기 위해 배열 초기화
        String[] nList = s.split("");
        // 정렬
        Arrays.sort(nList);
        // 오름차순으로 정렬된 원소 역순으로 문자열로 초기화
        for(int i = s.length() - 1; i >= 0; i--) {
            revSortedList += nList[i];
        }
        System.out.println(revSortedList);
        // 문자열을 정수로 변환
        answer = Long.parseLong(revSortedList);
        return answer;
    }
}