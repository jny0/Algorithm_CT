import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String binary = changeToBinaryString(arr1[i]|arr2[i], n);
            answer[i] = binary.replaceAll("1","#").replaceAll("0"," ");
        }

        return answer;
    }

    public static String changeToBinaryString(int a, int n){
        String binary = Integer.toBinaryString(a);
        if (binary.length() < n) {
            int diff = n - binary.length();
            String padding = "0".repeat(diff);
            binary = padding + binary;
        }
        return binary;
    }
}