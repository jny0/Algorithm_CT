class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int result = 0;
        int temp = x;
        while(true){
            result += temp%10;
            temp /= 10;
            if(temp < 10) break;
            
        }
        
        result += temp;
        if(x%result != 0) answer = false;
        
        return answer;
    }
}