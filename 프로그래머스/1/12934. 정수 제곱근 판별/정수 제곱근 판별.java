import java.lang.Math;

class Solution {
    public long solution(long n) {
        // 제곱근
        double sqrt = Math.sqrt(n);
        // 제곱근 x가 long 일 때 x+1 의 제곱 반환
        if(sqrt - (long)sqrt == 0) {
            return (long)((sqrt+1) * (sqrt+1));
        }
        return -1;
    }
}