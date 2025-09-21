import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int candidate = Math.min(citations[i], citations.length-i);
            h = Math.max(h, candidate);
        }
        return h;
    }
}