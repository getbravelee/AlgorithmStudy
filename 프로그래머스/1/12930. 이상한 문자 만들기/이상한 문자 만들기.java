class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        StringBuilder sb = new StringBuilder();
        boolean isWord = true;
        int idx = 0;
        for(int i = 0; i < words.length; i++) {
            // 공백 일 때
            if(words[i].isBlank()) {
                sb.append(" ");
                isWord = false;
            }
            // 문자 일 때
            else {
                if(!isWord) {
                    isWord = true; // 현재 단어임을 확인
                    idx = 0; // 인덱스 초기화
                }
                if(idx % 2 == 0) {
                    sb.append(words[i].toUpperCase());
                    idx++;
                }
                else {
                    sb.append(words[i].toLowerCase());
                    idx++;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}