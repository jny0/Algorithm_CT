import java.util.*;
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        
        List<Long> list = new ArrayList<>();
        
        long num = x;
        while(list.size() < n){
            list.add (num);
            num += x;
        }
        
        answer = list.stream().mapToLong(Long::longValue).toArray();
        
        return answer;
    }
}