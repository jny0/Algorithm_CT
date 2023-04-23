import java.util.PriorityQueue;
import java.util.Comparator;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("I")) {
                String[] strings = operations[i].split(" ");
                pqMin.offer(Integer.parseInt(strings[1]));
                pqMax.offer(Integer.parseInt(strings[1]));
            } else if (operations[i].equals("D -1")) {
                pqMax.remove(pqMin.poll());
            } else if (operations[i].equals("D 1")) {
                pqMin.remove(pqMax.poll());
            }
        }


        if (!(pqMin.isEmpty() && pqMax.isEmpty())) {
            answer[0] = pqMax.peek();
            answer[1] = pqMin.peek();
        }

        return answer;
    }
}