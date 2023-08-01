import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
       List<String> answerList = new ArrayList<>(Arrays.asList("RT", "CF", "JM", "AN"));
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++){
            String type = survey[i];
            if(answerList.contains(type)){
                 map.put(type, map.getOrDefault(type, 0) + (4 - choices[i]));
            } else{
                type = switchSurveyAnswer(type);
                map.put(type, map.getOrDefault(type, 0) + (choices[i] - 4));
            }
        }
        
        for(String key : map.keySet()){
            System.out.println(key + " : " + map.get(key));
        }
        
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<answerList.size(); i++){
            int score = map.getOrDefault(answerList.get(i), 1);
            if(score >= 0){
               answer.append(answerList.get(i).charAt(0));
            }else{
                answer.append(answerList.get(i).charAt(1));
            }
        }
        
        return answer.toString();
    }
    
    public String switchSurveyAnswer(String answer){
        StringBuilder newAnswer = new StringBuilder();
        newAnswer.append(answer.charAt(1));
        newAnswer.append(answer.charAt(0));
        return newAnswer.toString();
    }
}