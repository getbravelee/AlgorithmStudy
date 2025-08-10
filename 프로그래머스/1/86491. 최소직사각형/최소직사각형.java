class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxTotalW = 0;
        int maxTotalH = 0;
        int w = 0;
        int h = 0;
        for(int i = 0; i < sizes.length; i++) {
            for(int j = 0; j < 2; j++) {
                w = Math.max(sizes[i][0], sizes[i][1]);
                h = Math.min(sizes[i][0], sizes[i][1]);
                sizes[i][0] = w;
                sizes[i][1] = h;
            }
            maxTotalW = Math.max(maxTotalW, w);
            maxTotalH = Math.max(maxTotalH, h);
        }
        answer = maxTotalW * maxTotalH;
        return answer;
    }
}