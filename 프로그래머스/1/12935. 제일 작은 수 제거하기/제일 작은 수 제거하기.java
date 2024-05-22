import java.lang.Math;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] except = {-1};
        // 배열 크기가 1이면 -1 return
        if(arr.length == 1) {
            list.add(-1);
            return except;
        }
        // 최솟값 찾기
        int min = arr[0];
        for(int i : arr) {
            min = Math.min(min, i);
        }
        // 최솟값 빼고 list에 추가
        for(int i : arr) {
            if(i != min) {
                list.add(i);
            };
        }
        // 정답
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}