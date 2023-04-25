class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int count = 0;
        int length = numbers.length;
       
        if(length%2 == 0){
            while(count != k){
                for(int i=1; i<=length; i+=2){
                    count++;
                    if(count == k) {
                        answer = i;
                        break;
                    }
                }
            }
        } else {
           while(count != k){
                for(int i=1; i<=length; i+=2){
                    count++;
                    if(count == k) {
                        answer = i;
                        break;
                    }
                }
               
               if(count == k) {
                    break;
               }
               
               
                for(int i=2; i<length; i+=2){
                    count++;
                    if(count == k) {
                        answer = i;
                        break;
                    }
                }

            }
        }   
        return answer;
    }
}