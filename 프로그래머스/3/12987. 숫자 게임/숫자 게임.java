import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        Queue<Integer> queue = new LinkedList<>();
        for(int b : B){
            queue.add(b);
        }
        
        int num = B[0];
        for(int a : A){
            if(!queue.isEmpty() && queue.peek() < num){
                break;
            }
            
            while(!queue.isEmpty()){
                num = queue.poll();
                if(a < num) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}