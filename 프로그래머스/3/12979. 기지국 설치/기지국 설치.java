class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int index = 0;
        
        while (now <= n) {
            if (index < stations.length && now >= stations[index] - w) {
                now = stations[index] + w + 1;
                index++;
            } else {
                now += w * 2 + 1;
                answer++;
            }
        }
        
        return answer;
    }
}