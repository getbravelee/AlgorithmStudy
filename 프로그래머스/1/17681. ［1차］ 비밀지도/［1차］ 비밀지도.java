// 크기 n*n 2차원 배열 초기화
// arr1에서 배열의 원소 해독하여 #을 찾는다
// 찾은 #을 처음에 초기화한 배열에 알맞은 자리에 저장한다
// arr2도 같은 방법으로 한다. 단, 이미 #이 있으면 넘어간다.

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
           String b1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(" ", "0");
            String b2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(" ", "0");       
            String s = "";
            for(int j = 0; j < n; j++) {
                if(b1.charAt(j) == '1' || b2.charAt(j) == '1') {
                    s += "#";
                } 
                else {
                    s += " ";
                }
            }
            answer[i] = s;
        }
        return answer;
    }
}