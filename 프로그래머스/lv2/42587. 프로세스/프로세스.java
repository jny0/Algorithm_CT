import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int ind = 0;

        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Node(i, priorities[i]));
        }

        Integer[] prArr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(prArr, Collections.reverseOrder());
        
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (prArr[ind] == node.priority) {
                answer++;
                ind++;
                if (location == node.index) break;
            } else {
                q.offer(node);
            }
        }
        return answer;
    }

    static class Node {
        int index;
        int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

    }
}