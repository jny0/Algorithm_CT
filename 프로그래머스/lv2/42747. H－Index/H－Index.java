import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            if(citations.length-1 - i == citations[i]){
                answer = citations[i];
                break;
            }else if(citations.length-1 - i < citations[i]){
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }
}