import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, String> timeMap = new HashMap<>();
        Map<String, Integer> fee = new HashMap<>();
        
        int parkingTime = 0;
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            String time = record[0];
            String carNumber = record[1];
            String type = record[2];
            
            if(type.equals("IN")){
                timeMap.put(carNumber, time);
            }else {
                String inTime = timeMap.remove(carNumber);
                parkingTime = timeCalculate(inTime, time);
                fee.put(carNumber, fee.getOrDefault(carNumber, 0) + parkingTime);                
            }
        }
        
        for(String num : timeMap.keySet()){
            parkingTime = timeCalculate(timeMap.get(num), "23:59");
            fee.put(num, fee.getOrDefault(num, 0) + parkingTime);              
        }
        
        int[] answer = new int[fee.size()];
        List<String> sortedCarNumber = new ArrayList<>(fee.keySet());
        Collections.sort(sortedCarNumber);
        
        for(int i=0; i<answer.length; i++){
            parkingTime = fee.get(sortedCarNumber.get(i));
            int basicTime = fees[0];
            double unitTime = (double)fees[2];
            if(parkingTime <= basicTime){
                answer[i] = fees[1];
            }else{
                answer[i] = fees[1] + (int)Math.ceil(((parkingTime - fees[0]) / unitTime)) * fees[3];
            }
        }
        
        return answer;
    }
    
    public int timeCalculate(String inTime, String outTime){
        String[] inTimeStr = inTime.split(":");
        String[] outTimeStr = outTime.split(":");
        
        int hour = Integer.parseInt(outTimeStr[0]) - Integer.parseInt(inTimeStr[0]);
        int minute = Integer.parseInt(outTimeStr[1]) - Integer.parseInt(inTimeStr[1]);
        
        return hour* 60 + minute;
    }
}