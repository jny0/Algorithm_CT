import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 1;
        
        String[] str = s.split("");
        System.out.println(Arrays.toString(str));
        
        int cnt = 1;
        String start = str[0];
        for(int i=1; i<str.length; i++){       
            if(cnt == 0){
                answer++;
                start = str[i];
            }
            
            if(!start.equals(str[i])){
                cnt--;
            }else{
                cnt++;
            }
        }        
        
        return answer;
    }
}