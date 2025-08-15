class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};

        for (String speak : babbling) {
            // 연속된 같은 발음은 불가능하므로 미리 치환하여 걸러냅니다.
            // 예를 들어, "ayaaya"는 발음할 수 없습니다.
            // 아래 코드는 연속된 발음을 다른 문자로 치환하여 이후 로직에 영향을 주지 않도록 합니다.
            if (speak.contains("ayaaya") || speak.contains("yeye") || speak.contains("woowoo") || speak.contains("mama")) {
                continue;
            }

            // 발음 가능한 단어들을 공백으로 치환합니다.
            // 이 때, String은 불변이므로 반환값을 다시 할당해야 합니다.
            speak = speak.replace("aya", " ");
            speak = speak.replace("ye", " ");
            speak = speak.replace("woo", " ");
            speak = speak.replace("ma", " ");

            // 공백을 모두 제거한 후 문자열이 비어있으면 발음 가능한 단어입니다.
            speak = speak.replace(" ", "");

            if (speak.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}