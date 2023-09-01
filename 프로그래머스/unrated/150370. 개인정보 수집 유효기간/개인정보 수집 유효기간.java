import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        int todayDate = getDate(today);
        Map<String, Integer> map =  new HashMap<>();
        for(String term : terms){
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }

        for(int i=0; i<privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            String type = temp[1];
            int expireDate = getDate(temp[0]) + map.get(type) - 1;
            
            if (expireDate < todayDate) {
                answerList.add(i+1);
            }
        }
        return answerList.stream().mapToInt(i->i).toArray();
    }

    public int getDate(String day){
        String[] dayStr = day.split("\\.");
        int year = Integer.parseInt(dayStr[0]) ;
        int month = Integer.parseInt(dayStr[1]);
        int date = Integer.parseInt(dayStr[2]) ;
        return (year * 28 * 12) + (month * 28) + (date);
    }

}