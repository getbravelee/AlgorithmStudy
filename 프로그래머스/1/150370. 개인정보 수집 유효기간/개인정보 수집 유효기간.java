/*
terms를 " "을 기준으로 hashmap으로 초기화
today를 "."을 기준으로 년,월,일 초기화 -> 총 일수 -> 년 : 년*12*28 월 : 월*28
privacies를 " "을 기준으로 우선 날짜와 알파벳을 분리
"."을 기준으로 년,월,일 초기화 -> 총 일수
년월일로 판단하기 어려울 것 같다 -> 전체 일수로 계산
*/
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        // 오늘 날짜
        String[] todayDate = today.split("\\.");
        int year = Integer.parseInt(todayDate[0]);
        int month = Integer.parseInt(todayDate[1]);
        int day = Integer.parseInt(todayDate[2]);
        int td = year*12*28 + month*28 + day;
        
        for(String s : terms) {
            String[] arr = s.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            
            String[] d = arr[0].split("\\.");
            int year1 = Integer.parseInt(d[0]);
            int month1 = Integer.parseInt(d[1]);
            int day1 = Integer.parseInt(d[2]);
            int total = year1*12*28 + month1*28 + day1;
            
            if(total + map.get(arr[1]) * 28 <= td) {
                list.add(i+1);
            }
            
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}