import java.util.*;
class Solution {
    static int map[][]; 
    static boolean visited[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MAX_VALUE;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];
        visited = new boolean[101][101];
        
        for(int i=0; i<rectangle.length; i++){
            int sX = rectangle[i][0] * 2;
            int sY = rectangle[i][1] * 2;
            int eX = rectangle[i][2] * 2;
            int eY = rectangle[i][3] * 2;
            
            for(int j=sX; j<=eX; j++){
                map[j][sY] = max;
                map[j][eY] = max;
            }    
            for(int j=sY; j<=eY; j++){
                map[sX][j] = max;
                map[eX][j] = max;
            }
        }
        
        for(int i=0; i<rectangle.length; i++){
            int sX = rectangle[i][0] * 2 + 1;
            int sY = rectangle[i][1] * 2 + 1;
            int eX = rectangle[i][2] * 2 - 1;
            int eY = rectangle[i][3] * 2 - 1;
            
            for(int j=sX; j<=eX; j++){
                map[j][sY] = 0;
                map[j][eY] = 0;
            }    
            for(int j=sY; j<=eY; j++){
                map[sX][j] = 0;
                map[eX][j] = 0;
            }
        }

        bfs(characterX*2, characterY*2);
        answer = map[itemX*2][itemY*2]/2;

        return answer;
    }
    
    public static void bfs(int characterX, int characterY){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(characterX, characterY));
        map[characterX][characterY] = 1;

        while(!queue.isEmpty()){
            
            Node node = queue.poll();
            int nodeX = node.x;
            int nodeY = node.y;           
            int count = map[nodeX][nodeY];
            
            for(int i=0; i<4; i++){
                int moveX = nodeX + dx[i];
                int moveY = nodeY + dy[i];
                
                if(moveX < 0 || moveY < 0 || moveX > 100 || moveY > 100 || visited[moveX][moveY]){
                    continue;
                }
                
                if(map[moveX][moveY] != 0){
                    queue.offer(new Node(moveX, moveY));        
                    visited[moveX][moveY] = true;
                    map[moveX][moveY] = Math.min(map[moveX][moveY], count+1);
                }                      
            }
        }
            
    }
    
    public static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
        
    
    
    
}