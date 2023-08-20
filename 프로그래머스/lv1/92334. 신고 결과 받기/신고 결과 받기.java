import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            countMap.put(id, 0);
        }

        for (String rep : report) {
            String[] str = rep.split(" ");
            String reporter = str[0];
            String reportedUser = str[1];
            
            if (reportMap.get(reporter).add(reportedUser)) {
                countMap.put(reportedUser, countMap.get(reportedUser) + 1);
            }
        }
    

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> listSet = reportMap.get(id_list[i]);
            for(String user : listSet){
                if(countMap.get(user) >= k) answer[i]++;
            }
        }

        return answer;
    }
}