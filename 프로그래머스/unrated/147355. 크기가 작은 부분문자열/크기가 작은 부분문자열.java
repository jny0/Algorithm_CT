class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int index = 0;
        while(index+p.length() < t.length() + 1){
            long number = Long.parseLong(t.substring(index, index+p.length()));            
            if(number <= Long.parseLong(p)){
                answer++;
            }
            index++;
        }
        
        return answer;
    }
}