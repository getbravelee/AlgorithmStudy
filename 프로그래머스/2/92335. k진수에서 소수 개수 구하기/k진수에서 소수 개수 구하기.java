import java.math.BigInteger;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // k진수 변환
        String s = Integer.toString(n, k);
        String[] arr = s.split("0");
        for (String str : arr) {
            // 빈 문자열을 무시
            if (!str.isEmpty()) {
                BigInteger num = new BigInteger(str);
                if (isPrime(num)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean isPrime(BigInteger num) {
        // 0과 1은 소수가 아니다
        if (num.compareTo(BigInteger.TWO) < 0) {
            return false;
        }
        // 2는 소수이다
        if (num.equals(BigInteger.TWO)) {
            return true;
        }
        // 2 이상의 숫자에 대해 소수 판별
        BigInteger sqrt = num.sqrt();
        for (BigInteger i = BigInteger.TWO; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}
