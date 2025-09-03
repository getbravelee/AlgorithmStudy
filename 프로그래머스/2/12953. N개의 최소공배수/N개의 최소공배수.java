import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        // 모든 수의 최대 공약수 구하기
        // 모든 수의 곱 / 최대 공약수
        
        int lcm = arr[0];
        for(int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }
        answer = lcm;
        return answer;
    }
    
    // 두 수의 최대 공약수
    public static int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
    // 두 수의 최소 공배수
    public static int getLCM(int a, int b) {
        return (a*b)/getGCD(a,b);
    }
}
