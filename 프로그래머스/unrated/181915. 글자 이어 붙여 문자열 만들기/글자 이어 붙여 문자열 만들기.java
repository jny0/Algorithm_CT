class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        char[] c = new char[my_string.length()];
        
        for(int i=0; i<my_string.length(); i++){
            c[i] = my_string.charAt(i);
        }
    
        
        for(int i=0; i<index_list.length; i++){
            sb.append(c[index_list[i]]);
        }
        
        return sb.toString();
    }
}