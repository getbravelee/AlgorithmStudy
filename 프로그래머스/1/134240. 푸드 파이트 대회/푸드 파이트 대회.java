// food의 길이는 4가 아니다. 2~9 이다. 주의.
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int cnt = food[i] / 2;
            sb.append(String.valueOf(i).repeat(cnt));
        }
        answer = sb + "0";
        answer += sb.reverse();
        return answer;
    }
}