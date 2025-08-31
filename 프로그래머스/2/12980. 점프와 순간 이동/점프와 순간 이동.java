import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        // 역순으로 풀기: 짝수면 2로 나누고 홀수면 1빼고 카운트
        while(n != 1) {
            if(n % 2 == 0) n /= 2;
            else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}