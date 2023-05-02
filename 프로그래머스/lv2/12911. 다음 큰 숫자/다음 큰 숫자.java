class Solution {
    public int solution(int n) {
//         int answer = 0;
//         int num = n+1;
//         String binaryString = Integer.toBinaryString(n).replaceAll("0","");
        
//         while(true){
//             String binaryString2 = Integer.toBinaryString(num).replaceAll("0","");
//             if(binaryString.length() == binaryString2.length()){
//                 answer = num;
//                 break;
//             }
//             num++;
//         }
        
//         return answer;
        
        int count = Integer.bitCount(n);
        int num = n+1;
        
        while(true){
            if(count == Integer.bitCount(num)){
                break;
            }
            num++;
        }
        
        return num;
    }
    
}