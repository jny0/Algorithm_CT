class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true){
            
            if(n%a == 0){
                n = b*(n/a);
                answer += n;
            } else {
                answer += b*(n/a);
                n = n%a + b*(n/a);
            }
        
            if(n<a) break;
        }
        
        
        return answer;
    }
}