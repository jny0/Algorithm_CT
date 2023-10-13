import java.util.*;
class Solution {
    static List<List<String>> allRoute;  
    static boolean visited[];
    static String[][] tickets;
    public String[] solution(String[][] tickets) {
        
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        dfs("ICN", route, 0);
        
        Collections.sort(allRoute, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                for (int i=0; i<list1.size(); i++) {
                        String s1 = list1.get(i);
                        String s2 = list2.get(i);
                        if (!s1.equals(s2)) {
                            return s1.compareTo(s2);
                        }
                    }
                    return 0;
            }
        });

        return allRoute.get(0).toArray(new String[allRoute.get(0).size()]);
    }
    
    public static void dfs(String current, List<String> route, int count){
        if(count == tickets.length){
            allRoute.add(new ArrayList<>(route));
            return;    
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(current) && !visited[i]){
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], route, count+1);
                
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }
    }
    
}