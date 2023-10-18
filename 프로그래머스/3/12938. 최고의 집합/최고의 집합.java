import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        
        if(n>s) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        int quotient = s/n;
        int remainder = s%n;
        
        for(int i=n-1; i>=0; i--){
            answer[i] = quotient;
            if(remainder > 0) {
                answer[i]++;
                remainder--;
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}