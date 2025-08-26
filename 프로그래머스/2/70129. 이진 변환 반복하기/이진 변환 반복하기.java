class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero_count = 0;
        int binary_count = 0;
        while(!s.equals("1")) {
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '0') {
                    zero_count++;
                }
            }
            s = s.replace("0", "");
            binary_count++;
            s = Integer.toBinaryString(s.length());
            
        }
        answer[0] = binary_count;
        answer[1] = zero_count;
        return answer;
    }
}