class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        int temp = 0;
        while(true) {
            if(n == 0 && (temp == 1 || temp == 2)) {
                break;
            }
            s += n % 3;
            temp = n % 3;
            n /= 3;
        }
        for(int i = s.length()-1; i >= 0 ; i--) {
            answer += (s.charAt(s.length() - 1 - i) - 48) * Math.pow(3, i);
        }
        return answer;
    }
}