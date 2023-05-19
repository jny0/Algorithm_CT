class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String value = Integer.toString(n, 3);
        
        StringBuilder sb = new StringBuilder();
        for (int i = value.length() -1; i >= 0; i--){
            sb.append(value.charAt(i));
        }
        
        answer = Integer.parseInt(sb.toString(), 3);
        
        return answer;
    }
}