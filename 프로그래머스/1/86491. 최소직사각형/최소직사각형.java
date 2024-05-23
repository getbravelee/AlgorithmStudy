import java.lang.Math;
class Solution {
    public int solution(int[][] sizes) {

        int max_h = 0;
        int max_w = 0;
        for(int i = 0; i < sizes.length; i++) {
            int h = Math.min(sizes[i][0], sizes[i][1]);
            int w = Math.max(sizes[i][0], sizes[i][1]);
            max_h = Math.max(max_h, h);
            max_w = Math.max(max_w, w);
        }
        
        return max_h * max_w;
    }
}