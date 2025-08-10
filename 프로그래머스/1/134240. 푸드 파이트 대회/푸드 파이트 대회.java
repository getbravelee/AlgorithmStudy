class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i]/2; j++) {
                sb.append(i);
            }
        }
        sb.append("0");
        String s = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(s.substring(0, s.length()-1));
        sb.append(sb2.reverse());
        answer = sb.toString();
        return answer;
    }
}