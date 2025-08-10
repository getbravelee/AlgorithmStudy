class Solution {
    
    public int solution(int a, int b, int n) {
        return recursion(a, b, n);
    }
    private int recursion(int a, int b, int n) {
        if(n < a) {
            return 0;
        }
        // 새로 교환한 콜라
        int new_bottle = (n / a) * b;
        // 교환하고 남은 콜라
        int remain_bottle = n % a;
        // 전체 콜라 = 새로 교환한 콜라 + (새로 교환한 콜라 + 교환하고 남은 콜라)로 교환할 콜라
        return new_bottle + recursion(a, b, new_bottle + remain_bottle);
    }
}