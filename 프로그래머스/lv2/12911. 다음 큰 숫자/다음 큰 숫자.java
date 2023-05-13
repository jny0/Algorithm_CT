class Solution {
    public int solution(int n) {
        
        int count = Integer.bitCount(n);
        int num = n+1;
        
        while(true){
            if(count == Integer.bitCount(num)){
                break;
            }
            num++;
        }
        
        return num;
    }
    
}