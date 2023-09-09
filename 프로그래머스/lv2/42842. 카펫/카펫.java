class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int a = -(brown-4) / 2;
        int b = yellow;
        answer[0] = (int)((-a + Math.sqrt(a*a- 4*b)) / 2 + 2);
        answer[1] = (int)((-a - Math.sqrt(a*a- 4*b)) / 2 + 2);
        
        return answer;
    }
}