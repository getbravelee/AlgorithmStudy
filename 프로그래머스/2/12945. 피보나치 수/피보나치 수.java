class Solution {
    static int[] nums;
    public int solution(int n) {
        nums = new int[100_001];
        int answer = 0;
        answer = fibo(n);
        return answer;
    }
    
    private static int fibo(int n) {
        nums[0] = 0;
        nums[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            nums[i] = (nums[i-2] + nums[i-1]) % 1234567;
        }
        return nums[n];
    }
}