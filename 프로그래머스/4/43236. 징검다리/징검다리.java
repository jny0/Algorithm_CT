import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance;
        int mid;
        while(start <= end){
            mid = (start + end) / 2;
            int sum = 0;
            
            int before = 0;
            for(int rock : rocks){
                if(rock - before < mid){
                    sum++;
                    continue;
                }
                before = rock;
            }
                              
            if(distance - before < mid) sum++;
            
            if(sum <= n){
                start = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                end = mid - 1;
            }

        }
        
        return answer;
    }
}