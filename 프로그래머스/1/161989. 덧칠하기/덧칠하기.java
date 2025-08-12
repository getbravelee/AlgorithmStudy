class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int count = section.length; // 색칠 해야할 벽 개수
        boolean[] check = new boolean[n];
        for(int i : section) {
            check[i-1] = true; // 색칠 해야할 벽
        }
        for(int i = 0; i < n; i++) {
            // 색칠 되지 않은 곳 왼쪽부터 채우기
            if(check[i]) {
                for(int j = i; j < i + m; j++) {
                    if(j >= check.length) break;
                    // 색칠
                    if(check[j]) {
                        check[j] = false;
                        count--; 
                    }
                }
                answer++;
            }
            if(count == 0) break;
        }
        
        return answer;
    }
}