class Solution {
    static int maxCount;
    public int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        maxCount = 0;
        dfs(dungeons, k, visited, 0);
        return maxCount;
    }
    private void dfs(int[][] dungeons, int fatigue, boolean[] visited, int cnt) {
        maxCount = Math.max(maxCount, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, fatigue - dungeons[i][1], visited, cnt + 1);
                visited[i] = false;
            }

        }
    }
}