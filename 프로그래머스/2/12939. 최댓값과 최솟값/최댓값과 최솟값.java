class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String str : nums) {
            max = Math.max(max, Integer.parseInt(str));
            min = Math.min(min, Integer.parseInt(str));
        }
        answer = min + " " + max;
        return answer;
    }
}