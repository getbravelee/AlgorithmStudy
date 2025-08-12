class Solution {
    public int solution(int number, int limit, int power) {
        // 모든 숫자의 약수 개수를 저장할 배열
        int[] divisors = new int[number + 1];

        // 에라토스테네스의 체와 유사한 방법으로 약수 개수 계산
        for (int i = 1; i <= number; i++) {
            // i의 배수들을 찾아 약수 개수를 증가시킴
            for (int j = i; j <= number; j += i) {
                divisors[j]++;
            }
        }

        int answer = 0;
        for (int num = 1; num <= number; num++) {
            int count = divisors[num];

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer;
    }
}