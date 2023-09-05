import java.util.*;
class Solution {
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int fee = fares[i][2];

            graph.get(start).add(new Node(end, fee));
            graph.get(end).add(new Node(start, fee));
        }

        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];

        startA = roop(a, startA);
        startB = roop(b, startB);
        start = roop(s, start);

        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, startA[i] + startB[i] + start[i]);

        return answer;
    }

    public static int[] roop(int start, int[] fees){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(fees, Integer.MAX_VALUE);
        pq.offer(new Node(start, 0));
        fees[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();  // 큐에서 노드 꺼내기
            int nodeIndex = node.index; // 꺼낸 노드의 인덱스
            int nodeFee = node.fee;  // 꺼낸 노드의 가중치

            if(nodeFee > fees[nodeIndex]) { // 이미 방문할 노드일 경우 넘어감
                continue;
            }

            for (Node linkedNode : graph.get(nodeIndex)) {
                int fee = fees[nodeIndex] + linkedNode.fee;
                if(fee < fees[linkedNode.index]) {
                    // 최단 거리 갱신
                    fees[linkedNode.index] = fee;
                    // 갱신 된 노드를 우선순위 큐에 넣어
                    pq.offer(new Node(linkedNode.index, fee));
                }
            }
        }

        return fees;
    }

    static class Node implements Comparable<Node>{
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

