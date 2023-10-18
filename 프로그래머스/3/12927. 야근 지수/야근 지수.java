import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return Integer.compare(b, a);
            }
        });
    
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        while(n > 0){
            int work = pq.poll();
            
            if(work == 0) return 0;
            
            pq.add(work - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
       
        return answer;
    }
}