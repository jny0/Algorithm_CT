class Solution {
    public int[] solution(int n, long left, long right) {
        long length = right - left + 1;
        int[] answer = new int[(int)length];
        
        int idx = 0;
        for(long i=left; i<=right; i++){
            int x = (int)(i/n) + 1;
            int y = (int)(i%n) + 1;
            
            if(x>y) answer[idx] = x;
            else answer[idx] = y;
            
            idx++;
        }
        
        return answer;
    }
}