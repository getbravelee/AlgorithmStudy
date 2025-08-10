import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        combination(numbers, 0, 0, 0);
        int[] answer = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private void combination(int[] arr, int start, int count, int sum) {
        if(count == 2) {
            set.add(sum);
            return;
        }
        for(int i = start; i < arr.length; i++) {
            combination(arr, i + 1, count + 1, sum + arr[i]);
        }
    }
}