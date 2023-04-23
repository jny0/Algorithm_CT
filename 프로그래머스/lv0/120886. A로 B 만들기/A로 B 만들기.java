import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<after.length(); i++){
            list.add(after.charAt(i));
        }
        
        for(int i=0; i<before.length(); i++){
            char c = before.charAt(i);
            
            if(list.contains(c)){
                list.remove(Character.valueOf(c));
            }else{
                answer = 0;
                break;
            }
        }
        
    
        return answer;
    }
}