import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int a = (int) Math.pow(10, 8);
        
        while(a > 0) {
            if(n / a != 0) {
                answer += n / a;
                n = n - (n / a) * a;
            }
            a /= 10;
        }

        return answer;
    }
}