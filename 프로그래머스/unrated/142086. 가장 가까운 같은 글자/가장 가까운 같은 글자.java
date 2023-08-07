import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            int position = map.getOrDefault(s.charAt(i), -1);
            if(position == -1){
                answer[i] = position;
            }else{
                answer[i] = i - position;
            }
            map.put(s.charAt(i), i);
        }
        
        return answer;
    }
}