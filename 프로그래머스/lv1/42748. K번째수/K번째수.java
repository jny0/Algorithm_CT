import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        
        
        for(int i=0; i<commands.length; i++){
            
            int startIndex = commands[i][0] - 1;
            int endIndex = commands[i][1] - 1;
            int targetIndex = commands[i][2] - 1;
            
            int length = endIndex - startIndex + 1;
            
            int[] result = new int[length];
            
            for(int j=0; j<length; j++){
                result[j] = array[startIndex+j];
            }
            
            Arrays.sort(result);
            answer[i] = result[targetIndex];
        
        }
        
        
        return answer;
    }
}