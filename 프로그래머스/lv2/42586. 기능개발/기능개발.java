import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int date = 0;
        int count = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i=0; i<progresses.length; i++){
            while(true){
                if(progresses[i] + speeds[i]*date >=100){
                    stack.push(1);
                    break;
                } else if((!stack.isEmpty())) {
                    list.add(stack.size());
                    while(!stack.isEmpty()) stack.pop();                    
                } 
                date++;
            }
            
        }
        
        list.add(stack.size());
        
        
        return list.stream().mapToInt(x->x).toArray();
    }
}