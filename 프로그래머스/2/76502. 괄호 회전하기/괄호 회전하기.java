import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();
         // 회전(0부터 문자열 길이만큼)
        for(int i = 0; i < len; i++) {
            String str = "";
            for(int j = i; j < len+i; j++) {
                char c = s.charAt(j%len);
                str += Character.toString(c);
            }

            // 올바른 문자열인지 판단
            if(isCorrect(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isCorrect(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '[' || c == '{' || c == '(') {
                st.push(c);
            }
            else {
                if(c == ']' && (st.isEmpty() || st.pop() != '[')) {
                    return false;
                }
                else if(c == '}' && (st.isEmpty() || st.pop() != '{')) {
                    return false;
                }
                else if(c == ')' && (st.isEmpty() || st.pop() != '(')) {
                    return false;
                }
            }
        }
        if(st.size() > 0) {
            return false;
        }
        return true;
    }
}