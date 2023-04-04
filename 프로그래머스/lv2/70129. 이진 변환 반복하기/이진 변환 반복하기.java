class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        String binaryString = s;
        
        while(!binaryString.equals("1")){
            String str = binaryString.replaceAll("0", "");
            answer[1] += binaryString.length() - str.length();
            binaryString = Integer.toBinaryString(str.length());
            answer[0]++;
        }
        
        return answer;
    }
}