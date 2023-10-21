import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        System.out.println(Arrays.deepToString(routes));
        
        int start = routes[0][0];
        int end = routes[0][1];
        
        for(int i=1; i<routes.length; i++){
            int nowS = routes[i][0];
            int nowE = routes[i][1];
            
            if(nowS <= end){
                start = Math.max(start, nowS);
                end = Math.min(end, nowE);
            }else{
                answer++;
                start = nowS;
                end = nowE;
            }
        }
        
        
        return answer;
    }
}