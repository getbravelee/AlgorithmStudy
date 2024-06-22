/*
입차 map을 통해 IN이라면 차량 번호, 입차 시간을 정의하고
OUT이면 출차시간 - 입차시간하여 total의 벨류로 초기화하고, 해당 map의 키벨류를 비운다.
만약 출차가 안찍혀 있다면 입차 map은 비워져있지 않을 것이고 23:59분을 시간 계산하여 위와 같이 계산해준다.
*/
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int partTime = fees[2];
        int partFee = fees[3];
        
        for (String record : records) {
            String[] tmp = record.split(" ");
            int time = getRealTime(tmp[0]);
            String car = tmp[1];
            String io = tmp[2];
            
            if (io.equals("IN")) {
                inMap.put(car, time);
            } else {
                int inTime = inMap.get(car);
                inMap.remove(car);
                int parkedTime = time - inTime;
                totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + parkedTime);
            }
        }

        // 입차만 하고 출차하지 않은 차량 처리
        int lastTime = 1439;
        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            int parkedTime = lastTime - inTime;
            totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + parkedTime);
        }

        // 차량 번호를 정렬하여 처리
        Object[] sortKey = totalTimeMap.keySet().toArray();
        Arrays.sort(sortKey);
        answer = new int[sortKey.length];

        for (int i = 0; i < answer.length; i++) {
            String car = (String) sortKey[i];
            int totalTime = totalTimeMap.get(car);
            int result = baseFee;
            if (totalTime > baseTime) {
                result += Math.ceil((double)(totalTime - baseTime) / partTime) * partFee;
            }
            answer[i] = result;
        }
        
        return answer;
    }
    
    public int getRealTime(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
}
