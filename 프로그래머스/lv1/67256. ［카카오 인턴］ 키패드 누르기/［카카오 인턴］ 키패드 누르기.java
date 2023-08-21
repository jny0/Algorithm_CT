import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int right = 10;
        int left = 12;

        for(int number : numbers){
            if(number == 0) number = 11;
            switch(number % 3){
                case 0:
                    sb.append("R");
                    right = number;
                    break;
                case 1:
                    sb.append("L");
                    left = number;
                    break;
                case 2:
                    int gapWithRight = calculateGap(right, number);
                    int gapWithLeft =  calculateGap(left, number);
                    if(gapWithRight > gapWithLeft) {
                        sb.append("L");
                        left = number;
                    }
                    else if(gapWithRight < gapWithLeft) {
                        sb.append("R");
                        right = number;
                    }else{
                        sb.append(hand.substring(0,1).toUpperCase());
                        if(hand.equals("right")) right = number;
                        else left = number;
                    }
            }
        }
        return sb.toString();
    }
    
    public int calculateGap(int a, int b){
        return Math.abs(a - b) / 3 + Math.abs(a - b) % 3;
    }
}
