
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(start, end);
        //System.out.println();
    }

    private static void Dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeIndex = node.index;
            int weight = node.weight;

            if (weight > distance[nodeIndex]) { // 이미 방문할 노드일 경우 넘어감
                continue;
            }

            for (Node linkedNode : graph.get(nodeIndex)) {
                if (weight + linkedNode.weight < distance[linkedNode.index]) {
                    // 최단 거리 갱신
                    distance[linkedNode.index] = weight + linkedNode.weight;
                    // 갱신 된 노드를 우선순위 큐에 넣어
                    pq.offer(new Node(linkedNode.index, distance[linkedNode.index]));
                }
            }
        }

        System.out.println(distance[end]);
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}