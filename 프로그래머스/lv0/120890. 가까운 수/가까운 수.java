class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<array.length; i++){   
            if(min > Math.abs(array[i]-n)){
                min = Math.abs(array[i]-n);
                answer = array[i];
            }else if(min == Math.abs(array[i]-n)){
                answer = Math.min(answer, array[i]);
            }
        }
        
        return answer;
    }
}