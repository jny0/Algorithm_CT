import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        

        for(int i=1; i<words.length; i++){
            
            char last = words[i-1].charAt(words[i-1].length()-1);
            char first = words[i].charAt(0);
            
            if( last!=first || list.contains(words[i])) {
               
                answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;

                break;
            }
            list.add(words[i]);
        }
        
        return answer;
    }
}