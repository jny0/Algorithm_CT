class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            
            if(arr[i].length()==0){
                sb.append(" ");

            } else{
                sb.append(arr[i].substring(0,1).toUpperCase());
                sb.append(arr[i].substring(1).toLowerCase());
                sb.append(" ");
            }
            
        }
        String answer = sb.toString();
        
    	if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return answer;
    	}
    	
        return answer.substring(0, answer.length()-1);
    }
}