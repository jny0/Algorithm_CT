import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<moves.length; i++){
            int doll = 0;
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    doll = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }  
            if(doll == 0) continue;
            if(!stack.isEmpty()){
                if(stack.peek() == doll){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(doll);
                }                
            }else{
                stack.push(doll);
            }
        }
        
        return answer;
    }
}