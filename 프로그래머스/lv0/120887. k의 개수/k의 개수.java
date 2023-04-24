import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String[] numList = new String[j-i +1];
        
        for(int n = i; n<=j; n++){
            numList[n-i] = String.valueOf(n);
        }

        for(int a = 0; a<numList.length; a++){
            for(int b=0; b<numList[a].length(); b++){
                int num = (int)(numList[a].charAt(b) - '0');
                if(num == k) answer++;
            }
        }
        return answer;
    }
}