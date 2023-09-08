import java.util.*;
class Solution {
    static boolean[] visited;
    static List<String> allRoute;
    static String[][] tickets;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", 0);
        
        Collections.sort(allRoute);
        
        return allRoute.get(0).split(" ");
    }

    public void dfs(String start, String route, int count){
        if(count == tickets.length){
            allRoute.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], count+1);
                visited[i] = false;
                
            }
        }

    }
}