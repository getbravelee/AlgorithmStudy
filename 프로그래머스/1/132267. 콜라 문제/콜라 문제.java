/*
n개의 빈병, a개 빈병 주고 b개의 콜라를 받는다.
콜라를 마시면 빈병이 되기 때문에 빈병을 받는다고 생각하자.
*/
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true) {
            if(n - a >= 0) {
                n -= a;
                n += b;
                answer += b;
            }
            else {
                break;
            }
        }
        return answer;
    }
}