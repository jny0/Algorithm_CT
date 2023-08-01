import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        for(String key : keymap){
            for(int i=0; i<key.length(); i++){
                map.put(key.charAt(i), Math.min(map.getOrDefault(key.charAt(i), i+1), i+1));
            }
        }
              
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                int count = map.getOrDefault(targets[i].charAt(j), -1);
                if(count == -1) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += count;
            }
        }
                        
        
        return answer;
    }
}