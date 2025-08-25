class Solution {
    boolean solution(String s) {
        boolean answer = false;
        if(s.substring(0,1).equals("(")) {
            int count = 0;
            
            String[] arr = s.split("");
            for(String str : arr) {
                if(str.equals("(")) {
                    count++;
                }
                else {
                    count--;
                }
                
                if(count < 0) {
                    break;
                }
            }
            
            if(count == 0) {
                answer = true;
            }
        }

        return answer;
    }
}