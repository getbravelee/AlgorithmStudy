import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        // 앞에 있는거 배포되기 전까지 뒤에 기능 완성되어도 배포할 수 없다
        // 만약 뒤에 기능이 완성되었다면, 앞에 기능이 완성되고 배포될 때 같이 된다
        // 며칠동안 개발될지 미지수 -> while
        // while에서 하루씩 카운트하면서 progresses[i] speeds[i] 를 더해준다
        // 만약, 100이 넘었다면 progresses에서 100 넘은 것을 순차적으로 찾고 갯수를 카운트하고 return 에 추가한다
        // 100 미만이 나오면 멈춘다
        // 모든 기능이 완성되었다면 while 종료 -> progresses까지 카운트하는 기능 갯수 변수설정
        int total_count = 0; // 현재까지 완성된 기능 수
        int count = 0; // 배포될 기능 수
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(total_count < progresses.length) {
            // 현재 완성된 기능이 있으면 배포
            for(int i = idx; i < progresses.length; i++) {
                if(progresses[i] < 100) {
                    break;
                }
                else {
                    idx++;
                    total_count++;
                    count++;
                }
            }
            if(count > 0) {
                list.add(count);
                count = 0;
            }
            
            for(int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                
            }
            
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}