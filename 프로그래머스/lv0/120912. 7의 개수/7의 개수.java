import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        
        StringBuilder sb = new StringBuilder();
        for(int i : array){
            sb.append(i);
        }
        
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '7') answer++;
        }
        
        System.out.println(sb);
        
        return answer;
    }
}