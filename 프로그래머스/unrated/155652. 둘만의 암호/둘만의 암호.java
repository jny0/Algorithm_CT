import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        List<Character> strList = new ArrayList<>();
 
        for(int i=0; i<26 ; i++){
            char alphabet = (char)('a' + i);
            if(skip.contains(String.valueOf(alphabet))){
                continue;
            }
            strList.add(alphabet);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int plus = strList.indexOf(c) + index;
            if(plus >= strList.size()){
                plus %= strList.size();
            }
            sb.append(strList.get(plus));
        }
        
        return sb.toString();
    }
}