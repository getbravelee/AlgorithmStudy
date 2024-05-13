/**
1. 배열을 소문자로 초기화하여 원소 하나씩 비교하는 방법
2. 문자열을 그대로 소문자로 변환하여 charAt()으로 비교하는 방법
**/ 

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // p, y 카운트
        int p = 0;
        int y = 0;
        // 소문자로 변환하여 배열 초기화
        String[] lowerS = s.toLowerCase().split("");
        // 배열을 돌며 p 또는 y 인지 카운트
        for(int i = 0; i < lowerS.length; i++) {
            if(lowerS[i].equals("p")) {p += 1;}
            else if(lowerS[i].equals("y")) {y += 1;}
        }
        // p, y 카운트가 다르면 false
        if (y != p) {answer = false;}
        
        return answer;
    }
}