import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        int answer = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            int c = a + (b * 2);

            pq.offer(c);
            answer++;
        }

        if (pq.peek() < K){
            answer = -1;
        }

        return answer;
    }
}