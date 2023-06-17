import java.util.*;

class Solution {
    public int solution(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
            } else{
                map.put(nums[i], 1);
            }
            
        }
        
        int answer =  nums.length / 2;
        if(map.size() < answer) answer = map.size();
        
        return answer;
    }
}