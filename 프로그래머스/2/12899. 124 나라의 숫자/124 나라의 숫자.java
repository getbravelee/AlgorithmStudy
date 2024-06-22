/*
효율성테스트에서 떨어져서 블로그 보고 풀었다.
*/
class Solution {
    public String solution(int n) {
		String answer = "";
		String[] nums = {"4", "1", "2"};
		
		while(n>0) {
			answer = nums[n%3] + answer;
			n = (n-1)/3;
		}
		
		System.out.println(answer);
		return answer;
	}
}