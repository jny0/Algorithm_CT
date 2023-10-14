import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<stones.length; i++){
            while(!dq.isEmpty() && stones[dq.getLast()] <= stones[i]){
               dq.removeLast();
            }
            
            dq.addLast(i);
            if(dq.getFirst() == i-k) dq.removeFirst();
            if(i >= k-1) answer = Math.min(answer, stones[dq.peek()]);
        }

        return answer;
    }
}