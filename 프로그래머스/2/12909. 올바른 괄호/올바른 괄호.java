import java.util.*;
// ( 이면 추가 ) 이면 빼기
// 비어있으면 true
// 안 비어있으면 false
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push('(');
            }
            else if(s.charAt(i) == ')') {
                if(st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}