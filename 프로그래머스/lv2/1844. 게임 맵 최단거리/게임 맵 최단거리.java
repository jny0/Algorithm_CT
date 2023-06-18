import java.util.*;

class Solution {
    static int visited[][];
    static Queue<Node> queue;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new int[n][m];
        queue = new LinkedList<>();
        
        bfs(maps, n, m);
        if(visited[n-1][m-1] != 0){
            answer = visited[n-1][m-1];
        }
        
        
        return answer;
    }
    
    public static void bfs(int[][] maps, int n, int m){
        visited[0][0] = 1;
        queue.add(new Node(0,0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
             for(int k=0; k<4; k++) {
                 int nx = node.x + dx[k];
                 int ny = node.y + dy[k];
                 
                 if(nx < 0 || ny < 0 || nx >=n || ny>= m || visited[nx][ny] != 0){
                     continue;
                 }
                 
                if(maps[node.x][node.y] == 1){
                    visited[nx][ny] = visited[node.x][node.y] +1;
                    queue.offer(new Node(nx, ny));
                }  
                 
             }
            
            }
            
            
        
    }
    
}

class Node {
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}