class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        if(arr.length == 1){
            answer = arr[0];
        } else {
            for (int i = 0; i < arr.length; i++){
                answer = (answer * arr[i]) / gcd(answer, arr[i]);
            }
        }
 
        return answer;
    }
    
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}