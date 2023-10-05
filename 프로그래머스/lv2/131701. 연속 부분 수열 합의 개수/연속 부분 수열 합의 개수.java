import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] sum = new int[n];
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int index = (i+j) % n;
                sum[j] += elements[index];
                set.add(sum[j]);
            }
        }
        
        return set.size();
    }
}