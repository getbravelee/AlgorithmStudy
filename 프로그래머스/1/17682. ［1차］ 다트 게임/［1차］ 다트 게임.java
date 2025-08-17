import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // 각 기회의 점수를 저장할 배열
        int[] shoot = new int[3];
        int shootIdx = 0; // 점수를 저장할 인덱스

        // dartResult를 순회할 인덱스
        int i = 0;
        while (i < dartResult.length()) {
            char ch = dartResult.charAt(i);

            // 1. 점수 파싱
            int score;
            if (Character.isDigit(ch)) {
                // 10점인 경우
                if (ch == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++; // '0'을 건너뛰기
                } else {
                    score = Character.getNumericValue(ch);
                }
                shoot[shootIdx] = score;
            }

            // 2. 보너스 연산
            i++; // 다음 문자로 이동
            char bonus = dartResult.charAt(i);
            if (bonus == 'D') {
                shoot[shootIdx] = (int) Math.pow(shoot[shootIdx], 2);
            } else if (bonus == 'T') {
                shoot[shootIdx] = (int) Math.pow(shoot[shootIdx], 3);
            }

            // 3. 옵션 연산
            if (i + 1 < dartResult.length() && (dartResult.charAt(i + 1) == '*' || dartResult.charAt(i + 1) == '#')) {
                i++; // 다음 문자로 이동
                char option = dartResult.charAt(i);
                if (option == '*') {
                    shoot[shootIdx] *= 2;
                    if (shootIdx > 0) {
                        shoot[shootIdx - 1] *= 2;
                    }
                } else if (option == '#') {
                    shoot[shootIdx] *= -1;
                }
            }
            shootIdx++; // 다음 기회로 이동
            i++; // 다음 문자열 탐색 시작
        }

        // 최종 점수 합산
        int answer = 0;
        for (int s : shoot) {
            answer += s;
        }

        return answer;
    }
}