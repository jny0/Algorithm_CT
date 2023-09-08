import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int[][] map = new int[m+1][n+1];
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        map[1][1] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] == -1) continue;
                if(map[i-1][j] > 0) map[i][j] += map[i-1][j] % mod;
                if(map[i][j-1] > 0) map[i][j] += map[i][j-1] % mod;
            }            
        }
        return map[m][n] % mod;
    }

}