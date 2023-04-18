
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> graph2 = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수 (마을 수)
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, time));
            graph2.get(end).add(new Node(start, time));
        }

        Dijkstra(X);

    }

    private static void Dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] time = new int[N + 1];
        int[] time2 = new int[N + 1];

        Arrays.fill(time, Integer.MAX_VALUE);

        time[0] = 0;
        time[start] = 0;
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int nodeIndex = node.index;
            int weight = node.weight;

            if(weight > time[nodeIndex]) continue;

            for (Node linkedNode : graph.get(nodeIndex)) {
                if(time[linkedNode.index] > weight + linkedNode.weight){
                    time[linkedNode.index] = weight + linkedNode.weight;
                    pq.offer(new Node(linkedNode.index, time[linkedNode.index]));
                }
            }
        }

        // System.out.println(Arrays.toString(time));

        Arrays.fill(time2, Integer.MAX_VALUE);
        time2[0] = 0;
        time2[start] = 0;
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int nodeIndex = node.index;
            int weight = node.weight;

            if(weight > time2[nodeIndex]) continue;

            for (Node linkedNode : graph2.get(nodeIndex)) {
                if(time2[linkedNode.index] > weight + linkedNode.weight){
                    time2[linkedNode.index] = weight + linkedNode.weight;
                    pq.offer(new Node(linkedNode.index, time2[linkedNode.index]));
                }
            }
        }

        // System.out.println(Arrays.toString(time2));

        for (int i = 0; i < time.length; i++) {
            time[i] += time2[i];
        }

        Arrays.sort(time);
        System.out.println(time[time.length-1]);

    }

    static class Node implements Comparable<Node>{
        private int index;
        private int weight;

        public Node(int index, int time){
            this.index = index;
            this.weight = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
