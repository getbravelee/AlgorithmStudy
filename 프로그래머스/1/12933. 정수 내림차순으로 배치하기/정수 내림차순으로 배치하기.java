import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length();i ++) {
            arr[i] = s.charAt(i) - 48;
        } 
        Arrays.sort(arr);
        int[] temp = new int[s.length()];
        for(int i = s.length()-1; i >= 0; i--) {
            temp[s.length()- 1 - i] = arr[i];
        }
        String str = "";
        for(int i = 0; i < s.length();i ++) {
            str += String.valueOf(temp[i]);
        } 
        answer = Long.parseLong(str);
        return answer;
    }
}