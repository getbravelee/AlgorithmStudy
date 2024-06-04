/*
공통 수를 찾아서 그 인덱스를 카운트
내림차순으로 answer에 넣어야되므로 역순으로 배열을 탐색하며
x, y 공통 수의 카운트 된 수 중에서 작은 값으로 answer에 추가
공통 수가 없으면 "-1" 반환
0이면 "0"으로 반환. 0이 중복되면 "00" 식으로 반환될 수 있으니 주의
*/
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        for(int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0'] += 1;
        }
        for(int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0'] += 1;
        }
        for(int i = 9; i >= 0; i--) {
            for(int j=0; j < Math.min(xCount[i], yCount[i]); j++) {
                answer.append(i);
            }
        }
        // 공통 수가 없을 때
        if(answer.length() == 0) {
            return "-1";
        } 
        // 공통 수가 0이 중복될 때
        else if(answer.toString().charAt(0) == 48) {
            return "0";
        }
        return answer.toString();
    }
}