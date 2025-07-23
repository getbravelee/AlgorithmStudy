import java.util.*;
class Solution {
    
    static boolean[] visited;
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        
        // target이 없을 때
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        dfs(begin, target, words, 0);
        return answer;
    }
        
        
    static void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }

        for(int i = 0; i < words.length; i++) {

            if(visited[i]) {
                continue;
            }
            
            int k = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    k++;   
                }
            }
            if(begin.length() - 1 == k) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
        return;
    }
}