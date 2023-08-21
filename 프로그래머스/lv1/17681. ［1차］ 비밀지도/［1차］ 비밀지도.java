import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String[] binary1 = changeToBinaryString(arr1[i], n);
            String[] binary2 = changeToBinaryString(arr2[i], n);
            StringBuilder sb = new StringBuilder();

            for(int j=0; j<n; j++){
                if(binary1[j].equals("0") && binary2[j].equals("0")){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static String[] changeToBinaryString(int a, int n){
        String binary = Integer.toBinaryString(a);
        if (binary.length() < n) {
            int diff = n - binary.length();
            String padding = "0".repeat(diff);
            binary = padding + binary;
        }
        return binary.split("");
    }
}