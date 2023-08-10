import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Character> strList = new ArrayList<>();
        List<Character> skipChar = new ArrayList<>();
        
        for(int i=0; i<skip.length(); i++){
            skipChar.add(skip.charAt(i));
        }
        
        for(int i=0; i<26 ; i++){
            char alphabet = (char)('a' + i);
            if(skipChar.contains(alphabet)){
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