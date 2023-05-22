import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int[] w = new int[sizes.length];
        int[] h = new int[sizes.length];
        
        for (int i = 0; i < sizes.length; i++){
            w[i] = Math.max(sizes[i][0], sizes[i][1]);
            h[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        Arrays.sort(w);
        Arrays.sort(h);
        
        answer = w[w.length - 1] *  h[h.length - 1];
        
        return answer;
    }
}