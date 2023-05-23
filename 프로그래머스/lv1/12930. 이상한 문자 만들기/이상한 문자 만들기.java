class Solution {
    public String solution(String s) {
        
        String[] arr = s.split("");
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < arr.length; i++){
            
            if(arr[i].equals(" ")) {
                idx = 0;
            } else if(idx % 2 == 0) {
                arr[i] = arr[i].toUpperCase();
                idx++;
            } else {
                arr[i] = arr[i].toLowerCase();
                idx++;
            }
            sb.append(arr[i]) ;
        }

        return sb.toString();
    }
}