class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int number = 0;
        for(int i=0; i<section.length; i++){
            if(number < section[i]){
                number = section[i] + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}