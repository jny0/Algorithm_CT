import java.util.*;
class Solution {
    static int maxSheepCount = 0;
    static int[] gInfo;
    static int[][] gEdges;
    public int solution(int[] info, int[][] edges) {

        gInfo = info;
        gEdges = edges;
        boolean[] initVisited = new boolean[info.length];
        dfs(initVisited, 0, 0, 0);

        return maxSheepCount;
    }

    static void dfs(boolean[] visited, int index, int sheepCount, int wolfCount){
        visited[index] = true;
        
        if(gInfo[index] == 0){
            sheepCount++;
            maxSheepCount = Math.max(sheepCount, maxSheepCount);
        }else{
            wolfCount++;
        }
        
        if(sheepCount <= wolfCount) return;
        
        for(int[] edge : gEdges){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] nextVisited = new boolean[visited.length];
            	for (int i = 0; i < visited.length; i++) {
                	nextVisited[i] = visited[i];
            	}
                dfs(nextVisited, edge[1], sheepCount, wolfCount);
            }
        }
    }
}