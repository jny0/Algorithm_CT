import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        int position = n;
            
        while(position != 1){
            if(position%2 == 0){
                position /= 2;                
            } else {
                position -= 1;
                ans++;
            } 
        }

        return ans;
    }
}