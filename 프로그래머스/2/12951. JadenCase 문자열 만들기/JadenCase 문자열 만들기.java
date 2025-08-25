class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirstChar = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                isFirstChar = true; // 다음 문자가 단어의 첫 글자가 될 수 있으므로 true로 설정
            } else {
                if (isFirstChar) {
                    answer.append(Character.toUpperCase(c));
                    isFirstChar = false;
                } else {
                    answer.append(Character.toLowerCase(c));
                }
            }
        }

        return answer.toString();
    }
}