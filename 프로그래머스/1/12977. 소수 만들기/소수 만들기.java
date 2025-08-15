class Solution {
static int answer = 0;
    public int solution(int[] nums) {   
        combination(nums, 0, 0, 0);

        return answer;
    }
    
    private static void combination (int[] arr, int start, int count, int sum) {
         if(count == 3) {
            int cnt = 0;
            for(int i = 1; i <= sum; i++) {
                if(sum % i == 0) {
                     cnt++;
                }
            }
            if(cnt == 2) {
               answer++;
            }
             return;
         }
        for(int i = start; i < arr.length; i++) {
          combination(arr, i+1, count+1, sum+arr[i]);
        }
    }
}