import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        // 원소가 얼마나 담길 지 알 수 없음 -> arrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        // list는 length가 아니가 size()를 사용하여 크기를 알 수 있다.
        if(list.size() == 0) {
            list.add(-1);
        }
        // list 타입의 정렬이기 때문에 Arrays가 아닌 Collections
        Collections.sort(list);
        // 반환타입이 정수형 배열
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}