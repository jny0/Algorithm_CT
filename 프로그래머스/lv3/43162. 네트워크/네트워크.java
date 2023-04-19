
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (check[i]) continue;

            check[i] = true;
            queue.offer(computers[i]);

            while (!queue.isEmpty()) {
                int[] computer = queue.poll();

                for (int j = 0; j < n; j++) {
                    if (!check[j] && computer[j] == 1) {
                        check[j] = true;
                        queue.offer(computers[j]);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
