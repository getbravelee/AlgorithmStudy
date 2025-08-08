class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int count = 0;
        for(String s : seoul) {
            if(s.equals("Kim")) {
                return "김서방은 " + count + "에 있다";
            }
            count++;
        }
        return answer;
    }
}