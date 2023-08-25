class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
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
        
        return new int[]{score(win_count + zero_count), score(win_count)};
    }
    
    public int score(int count){
        switch(count){
            case 6: 
                return 1;
            case 5: 
                return 2;
            case 4: 
                return 3;
            case 3: 
                return 4;
            case 2: 
                return 5;
            default: 
                return 6;
        }
    }
}