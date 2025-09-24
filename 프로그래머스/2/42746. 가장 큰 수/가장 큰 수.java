import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for(String s : nums) {
            answer += s;
        }
        if(answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}