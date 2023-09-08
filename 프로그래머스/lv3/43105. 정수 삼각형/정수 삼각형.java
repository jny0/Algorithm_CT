import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int dp[][] = new int[triangle.length][triangle[triangle.length-1].length];
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<triangle.length; i++){
            int last = triangle[i].length - 1;
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][last] = dp[i-1][last-1] + triangle[i][last];
        }
        
        for(int i=2; i<triangle.length; i++){
            for(int j=triangle[i].length-i; j<triangle[i].length-1; j++){
                int previous = Math.max(dp[i-1][j-1], dp[i-1][j]);
                dp[i][j] = previous + triangle[i][j];
            }
        }
        
        int answer = Arrays.stream(dp[dp.length-1]).max().orElse(-1);
        
        return answer;
    }
}