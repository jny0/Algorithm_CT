class Solution {
    public String[] solution(String my_str, int n) {
        
        int length = my_str.length()/n;
        if((my_str.length()%n) != 0) length++;
        
        String[] answer = new String[length];
        
        for(int i=0; i<length; i++){
            if(i == length-1){
                answer[i] = my_str.substring(n*i);
            } else{
                answer[i] = my_str.substring(n*i,n*(i+1));  
            }

        }      
        
        return answer;
    }
}