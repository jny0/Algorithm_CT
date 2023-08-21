import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());
        
        for(int i=0; i<score.length; i++){
            if(i % m == (m-1)){
                answer += tmp[i]*m;
            }
        }
        
        return answer;
    }
}