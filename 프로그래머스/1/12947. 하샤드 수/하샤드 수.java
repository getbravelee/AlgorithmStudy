class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        // 문자열로 변환
        String s = "" + x;
        // 각 숫자 배열로 초기화
        String[] arr = s.split("");
        // 원소 합
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += Integer.valueOf(arr[i]);
        }
        // 하샤드 수 판별
        if(x % sum != 0) {
            return false;
        }
        return answer;
    }
}