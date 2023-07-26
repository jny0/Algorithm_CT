class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int times = 1;
        int sum = 0;
        for(int i=0; i<num_list.length; i++){
            times *= num_list[i];
            sum += num_list[i];
        }
        
        if(times < Math.pow(sum, 2)){
            answer = 1;
        }
        
        return answer;
    }
}