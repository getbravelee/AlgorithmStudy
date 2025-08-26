class Solution {
    public int solution(int n) {
        int originalOneCount = Integer.bitCount(n); // n의 1의 개수 계산
        int nextNumber = n + 1;

        while (true) {
            int nextOneCount = Integer.bitCount(nextNumber);
            
            if (nextOneCount == originalOneCount) {
                return nextNumber;
            }
            nextNumber++;
        }
    }
}
