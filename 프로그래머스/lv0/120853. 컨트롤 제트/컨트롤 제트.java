import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        
        System.out.println(Arrays.toString(str));
        
        for(int i=0; i<str.length; i++){
            if(str[i].equals("Z")){
                answer -= Integer.parseInt(str[i-1]);
            }else{
                answer += Integer.parseInt(str[i]);
            }
        }   
        
        return answer;
    }
}