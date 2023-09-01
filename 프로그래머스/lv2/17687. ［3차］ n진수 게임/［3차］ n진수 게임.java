class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        int num = 0;
        while(sb.length() < t*m){
            String numStr = Integer.toString(num, n).toUpperCase();
            sb.append(numStr);
            num++;
        }
        
        int index = p-1;
        for(int i=0; i<t; i++){
            result.append(sb.toString().charAt(index));
            index += m;
        }
        
        System.out.println(sb.toString());
        
        return result.toString();
    }
}