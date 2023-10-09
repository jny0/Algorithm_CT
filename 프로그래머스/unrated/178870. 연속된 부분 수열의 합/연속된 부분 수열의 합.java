import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for(int end=0; end<sequence.length; end++){
            sum += sequence[end];

            while(sum >= k){
                int length = end-start+1;
                if(sum == k && minLength > length){
                    minLength = length;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            }        
        }
        
        return answer;
    }
}