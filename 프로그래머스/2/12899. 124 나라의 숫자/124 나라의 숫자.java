import java.util.*;
class Solution {
    public String solution(int n) {
        int[] plus = {1, 2, 4};
        
        Stack<Integer> stack = new Stack<>();

        while(n != 0){
            int now = (n-1)%3;
            n = (n-1)/3;

            stack.push(plus[now]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}