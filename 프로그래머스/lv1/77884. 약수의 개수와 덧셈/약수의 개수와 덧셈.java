import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++){
            if(divisor(i)%2 == 0){
                answer+=i;
            }else {
                answer-=i;
            }
        }
                
        return answer;
    }
    
    public static long divisor(int n){
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0) list.add(i);
        }
        
        int size = list.size();
        
        for (int i = 0; i < size; i++){
            if(n%list.get(i) == 0) list.add(n/list.get(i));
        }        
        
        
        return list.stream().distinct().count();
        
    }

}