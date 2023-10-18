import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance;
    public int solution(int n, int[][] edge) {
        int answer = 0;
  
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0] - 1).add(edge[i][1] - 1);
            graph.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }
        
        distance = new int[n];
        int max = move(n, 0);
        
        for(int dis : distance){
            if(dis == max) answer++;
        }

        return answer;
    }
    
    public static int move(int n, int index){
        int max = 0;
        Queue<Integer> pq = new LinkedList<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[index] = 0;
        pq.offer(index);
    
        
        while(!pq.isEmpty()){
            int node = pq.poll();
            int newDistance = distance[node] + 1;
 
             for (int linkedNode : graph.get(node)) {
                 if(newDistance < distance[linkedNode]) {
                     distance[linkedNode] = newDistance;
                     pq.offer(linkedNode);
                     max = Math.max(max, newDistance);
                 }
             }
        }
        
        return max;
    }    
}