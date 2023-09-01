import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {

        int count = stages.length;
        
        int[] pre = new int[N+1];
    
        for(int i=0; i<stages.length; i++){
            pre[stages[i]-1]++;
        }
        
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            double failRate = (double)pre[i]/count;
            if(count == 0) failRate = 0;
            pq.offer(new Stage(i+1, failRate));
            count -= pre[i];
        }       

        int[] answer = new int[pq.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = pq.poll().stageNumber;
        }
        
        return answer;
    }
    
    public class Stage implements Comparable<Stage>{
        int stageNumber;
        double failRate;
        
        public Stage(int stageNumber, double failRate){
            this.stageNumber = stageNumber;
            this.failRate = failRate;
        }
        
        public int compareTo(Stage s){
            if (this.failRate == s.failRate) {
                return Integer.compare(this.stageNumber, s.stageNumber);
            }
            return Double.compare(s.failRate, this.failRate);
        }
    }
    
}