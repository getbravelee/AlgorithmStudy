// HashMap을 통해 키와 밸류를 정하기
// 숫자는 무조건 길이가 1이니까 char로 한문자씩 쪼개서 숫자인지 판단
// 문자이면 빈 문자열에 하나씩 문자열을 더해서 밸류 값에 있는 값인지 판단하여 해당하는 키 값으로 변환
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        // 정답으로 바꾸기 위한 숫자(문자열)
        String result = "";
        // 문자로 만든 영단어
        String str_num = "";
        Map<String, String> map = Map.of(
            "zero", "0",
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
        );
        char[] c = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            // 숫자일 때
            if(Character.isDigit(c[i])) {
                result += c[i];
            }
            // 문자일 때
            else {
                str_num += c[i];
                if(map.containsKey(str_num)) {
                    result += map.get(str_num);
                    str_num = "";
                }
            }
        }
        answer = Integer.valueOf(result);
        return answer;
    }
}