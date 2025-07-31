class 문제1 {
    public int solution(int[] s1, int[] s2) {
        int answer = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int number : s1) {
            sum1 += number;
        }

        for (int number : s2) {
            sum2 += number;
        }

        answer = sum1 - sum2;

        return answer;

    }
}
