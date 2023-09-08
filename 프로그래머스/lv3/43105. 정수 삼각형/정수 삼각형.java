import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
        for(int i=1; i<triangle.length; i++){
            int last = triangle[i].length - 1;
            triangle[i][0] += triangle[i-1][0];
            triangle[i][last] += triangle[i-1][last-1];
            for(int j=triangle[i].length-i; j<triangle[i].length-1; j++){
                int previous = Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                triangle[i][j] += previous;
            }
        }
        
        int answer = Arrays.stream(triangle[triangle.length-1]).max().orElse(-1);
        
        return answer;
    }
}