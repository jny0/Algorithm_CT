import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<emergency.length; i++){
            map.put(emergency[i], i);
        }
        
        Integer[] arr = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i=0; i<arr.length; i++){
            answer[map.get(arr[i])] = i +1;
        }
           
        return answer;
    }
}