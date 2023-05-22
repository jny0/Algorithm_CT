class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            
            if(a == ' '){
                sb.append(" ");
            }
            else if(a<=90){
                if(a+n > 90){
                    sb.append((char)(a + n - 26));
                }else{
                    sb.append((char)(a + n));
                }
            }
            else if (a<=122){
                if(a+n > 122){
                    sb.append((char)(a + n - 26));
                }else{
                    sb.append((char)(a + n));
                }
            }
            
        }
        
        return sb.toString();
    }
}