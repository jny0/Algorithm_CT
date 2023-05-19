import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0) list.add(i);
        }

        int size = list.size();

        for (int i = 0; i < size; i++){
            if(n%list.get(i) == 0) list.add(n/list.get(i));
        }

        answer = list.stream().distinct().mapToInt(Integer::intValue).sum();

        return answer;
    }
}