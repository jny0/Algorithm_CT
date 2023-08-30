import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if(!str[0].equals("Change")){
                list.add(str);
            }
            if(!str[0].equals("Leave")){
                map.put(str[1], str[2]);
            }
        }     
        
        int idx = 0;
        String[] answer = new String[list.size()];
        for(String[] str : list){
            String username = map.get(str[1]);
            if(str[0].equals("Enter")) answer[idx] = username + "님이 들어왔습니다.";
            if(str[0].equals("Leave")) answer[idx] = username + "님이 나갔습니다.";
            idx++;
        }         
        return answer;
    }
}