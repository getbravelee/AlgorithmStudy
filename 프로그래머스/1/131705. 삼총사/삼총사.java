class Solution {
    static int answer = 0;

    public int solution(int[] number) {

        combination(number, 0, 0, 0);
        return answer;
    }
    static void combination(int[] arr, int start, int count, int sum) {
        if(count == 3) {
            if(sum == 0) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i < arr.length; i++) {
            combination(arr, i+1, count+1, sum + arr[i]);
        }
    }
}