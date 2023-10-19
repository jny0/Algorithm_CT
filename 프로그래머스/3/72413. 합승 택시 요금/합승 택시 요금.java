import java.util.*;
class Solution {
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[] fees = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int fee = fares[i][2];
            
            graph.get(start).add(new Node(end, fee));
            graph.get(end).add(new Node(start, fee));
        }
        
        int[] total = roop(s, n);
        int[] A = roop(a, n);
        int[] B = roop(b, n);
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, total[i] + A[i] + B[i]);
        }
        
        return answer;
    }
    
    public static int[] roop(int start, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        int[] fees = new int[n+1];
        Arrays.fill(fees, Integer.MAX_VALUE);
        fees[start] = 0; 
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nodeIndex = node.index;
            int nodeFee = node.fee;
            
            for(Node next : graph.get(nodeIndex)){
                int fee = next.fee + fees[nodeIndex];
                if(fees[next.index] > fee){
                    fees[next.index] = fee;
                    pq.offer(new Node(next.index, fee));
                }
            }
        }
        return fees;
    }
    
    
    static class Node implements Comparable<Node> {
        private int index;
        private int fee;

        public Node(int index, int fee) {
            this.index = index;
            this.fee = fee;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.fee, o.fee);
        }
    }

}