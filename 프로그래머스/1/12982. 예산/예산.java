import java.lang.Math;
import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int cnt = 0;
        int sum = 0;
        // 오름차순 정렬 -> 가장 낮은 값 부터 더하면 최대 카운트이다.
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            if(sum + d[i] <= budget) {
                sum += d[i];
                cnt += 1;
            }
        }
        return cnt;
    }
}