import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int endTime = 0;
        int count = 0;
        int index = 0;
        while(count < jobs.length){
            
            while(index < jobs.length && jobs[index][0] <= endTime ){
                pq.offer(jobs[index++]);
            }
            
            if(!pq.isEmpty()){
                answer += endTime - pq.peek()[0] + pq.peek()[1];
                endTime +=  pq.peek()[1];
            
                pq.poll();
                count++;
            }else{
                endTime = jobs[index][0];
            }

        }

        return answer/jobs.length;
    }
}
