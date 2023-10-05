import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            String str = s.substring(i, n) + s.substring(0, i);
            if(checkBracket(str)) answer++;
        }

        return answer;
    }
    
    public static boolean checkBracket(String str){
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '(' ||  c == '[' || c == '{'){
                stack.push(c);
            } else if(!stack.isEmpty()) {
                if(c == ')' ) {
                    if(stack.peek() != '(') break;
                } else if(c == '}' ) {
                    if(stack.peek() != '{') break;
                } else if(c == ']' ) {
                    if(stack.peek() != '[') break;
                }
                stack.pop();
            } else if(stack.isEmpty()){
                stack.push(c);
            }
        }
        
        if(stack.isEmpty()) result = true;
        return result;
    }
}