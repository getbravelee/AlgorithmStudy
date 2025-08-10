class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 소문자일 때
            if('a' <= c && 'z' >= c) {
                // z 넘어설 때
                if(c + n > 'z') {
                    c = (char)('a' + (c + n - 'a') % 26);
                }
                else {
                    c = (char)(c + n);
                }
            }
            // 대문자 일 때
            else {
                if('A' <= c && 'Z' >= c) {
                    if(c + n > 'Z') {
                        c = (char)('A' + (c + n - 'A') % 26);
                    }
                    else {
                        c = (char)(c + n);
                    }
                }
            }        
            arr[i] = c;
        }
        for(char c : arr) {
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}