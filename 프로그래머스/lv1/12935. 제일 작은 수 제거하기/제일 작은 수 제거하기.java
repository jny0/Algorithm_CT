import java.util.*;
class Solution {
    public int[] solution(int[] arr) {

        if(arr.length == 1) return new int[]{-1};
        
        int num =  Arrays.stream(arr).min().getAsInt();
        int[] answer =  Arrays.stream(arr).filter(i-> i>num).toArray();


        return answer;
    }
}