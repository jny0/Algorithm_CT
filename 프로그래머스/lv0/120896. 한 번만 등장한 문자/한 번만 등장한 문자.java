import java.util.*;

class Solution {
    public String solution(String s) {
        int a = -1;
        
        while(a!=s.length()){
            a++;
            for(int j= a+1; j<s.length(); j++ ){
                if(s.charAt(a) == s.charAt(j)){
                    s = s.replace(String.valueOf(s.charAt(a)), "");
                    a = -1;
                    break;
                }
            }

        }

        char[] c = s.toCharArray();
        Arrays.sort(c);

        return String.valueOf(c);
    }
}