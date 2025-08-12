import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while(true){
            // 지갑의 가로, 세로 길이를 정렬합니다.
            int wallet_min = Math.min(wallet[0], wallet[1]);
            int wallet_max = Math.max(wallet[0], wallet[1]);

            // 지폐의 가로, 세로 길이를 정렬합니다.
            int bill_min = Math.min(bill[0], bill[1]);
            int bill_max = Math.max(bill[0], bill[1]);

            // 지폐가 지갑에 들어갈 수 있으면 반복문을 종료합니다.
            if(bill_min <= wallet_min && bill_max <= wallet_max){
                break;
            } else {
                // 지폐를 접는 로직: 가장 긴 변을 반으로 접습니다.
                if(bill[0] > bill[1]){
                    bill[0] /= 2;
                } else {
                    bill[1] /= 2;
                }
                answer++;
            }
        }
        return answer;
    }
}