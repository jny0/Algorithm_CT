import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> sellerIndexMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            sellerIndexMap.put(enroll[i], i);
        }
        
        for(int i=0; i<seller.length; i++){
                  
            String nowSeller = seller[i];
            int profit = amount[i] * 100;
            
            while(!nowSeller.equals("-")){
                int profitForParent = profit / 10;
                int nowProfit = profit - profitForParent;
                
                answer[sellerIndexMap.get(nowSeller)] += nowProfit;
                nowSeller = parentMap.get(nowSeller);
                profit /= 10;
                
                if(profit < 1) break;
            }
            
        }
        
        
        return answer;
    }
}