class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;
        int[] dp = new int[length];
        
        if (length == 1) return sticker[0];
        
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i=2; i<length; i++){
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        answer = dp[length - 2];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<length; i++){
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        answer = Math.max(answer, dp[length - 1]);

        return answer;
    }
}