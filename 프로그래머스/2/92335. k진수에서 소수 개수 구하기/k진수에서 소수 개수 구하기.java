class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // k진수 변환
        String s = Integer.toString(n, k);
        String[] arr = s.split("0");
        for (String str : arr) {
            // 빈 문자열을 무시
            if (!str.isEmpty()) {
                try {
                    long num = Long.parseLong(str);
                    if (isPrime(num)) {
                        answer++;
                    }
                } catch (NumberFormatException e) {
                    // 숫자가 너무 커서 long으로 변환할 수 없을 때
                    continue;
                }
            }
        }
        return answer;
    }

    public boolean isPrime(long num) {
        // 0과 1은 소수가 아니다
        if (num < 2) {
            return false;
        }
        // 2는 소수이다
        if (num == 2) {
            return true;
        }
        // 2 이상의 숫자에 대해 소수 판별
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}