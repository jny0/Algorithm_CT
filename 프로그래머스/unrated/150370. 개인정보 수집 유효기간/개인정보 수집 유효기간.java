import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();

        int todayInt = Integer.parseInt(today.replaceAll("\\.", ""));
        System.out.println(todayInt);

        Map<String, Integer> map =  new HashMap<>();
        for(String term : terms){
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }

        for(int i=0; i<privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            String[] pDate = temp[0].split("\\.");
            String type = temp[1];

            int eYear = Integer.parseInt(pDate[0]) ;
            int eMonth = Integer.parseInt(pDate[1]) + map.get(type);
            int eDate = Integer.parseInt(pDate[2]) - 1;
            
            if(eDate == 0) {
                eMonth--;
                eDate = 28;
            }
            if(eMonth > 12) {
                eYear += eMonth/12 ;
                eMonth %= 12;
            }
            if(eMonth == 0){
                eYear--;
                eMonth = 12;
            }

            int expireDate = eYear * 10000 + eMonth* 100 + eDate;

            if (expireDate < todayInt) {
                answerList.add(i+1);
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }

}