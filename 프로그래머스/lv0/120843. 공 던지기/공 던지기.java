
class Solution {
    public int solution(int[] numbers, int k) {
        int count = 0;
        int answer = 0;
        for(int i=0; i<k-1; i++) {
            count = count + 2;
            if(count > numbers.length-1) {
               count =  count - numbers.length;
            }
            answer = numbers[count];
        }

        return answer;
    }
}