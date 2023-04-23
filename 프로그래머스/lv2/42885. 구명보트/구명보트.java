import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int count = 0;
        
        Arrays.sort(people);
        ArrayDeque<Integer> deque = new ArrayDeque<>(50001);
        
        for(int i=0; i<people.length; i++){
            deque.addLast(people[i]);
        }
        
         System.out.println(deque.toString());
        
        while(!deque.isEmpty()){
            int first = deque.peekFirst();
            int last = deque.pollLast();
            
            if(first+last <= limit){
                deque.pollFirst();
            } 
            answer++;
        }
        
        return answer;
    }
}