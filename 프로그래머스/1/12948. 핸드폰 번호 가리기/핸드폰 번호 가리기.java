class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] num = phone_number.split("");
        for(int i = 0; i < phone_number.length()-4; i++) {
            num[i] = "*";
            answer += num[i];
        }
        for(int i = phone_number.length()-4; i < phone_number.length(); i++) {
            answer += num[i];
        }
        return answer;
    }
}