class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        int win_count = 0;
        int zero_count = 0;
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zero_count++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    win_count++;
                    break;
                }
            }
        }
        
        return new int[]{rank[win_count + zero_count], rank[win_count]};
    }

}