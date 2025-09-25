class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = 0;
        for(int t : times) {
            right = (long)Math.max(right, t);
        }
        right *= (long)n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            
            for(int t : times) {
                people += mid / t;
                if(people >= n) break;
            }
            if(people >= n) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }
}