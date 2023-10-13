import java.util.*;
class Solution {
    static List<String> allRoute;  
    static boolean visited[];
    static String[][] tickets;
    public String[] solution(String[][] tickets) {
        
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        
        dfs("ICN","ICN", 0);
        Collections.sort(allRoute);
        
        return allRoute.get(0).split(" ");
    }
    
    public static void dfs(String current, String route, int count){
 
        if(count == tickets.length){
            allRoute.add(route);
            return;    
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(current) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1] ,count+1);
                visited[i] = false;
            }
        }
    }
    
}