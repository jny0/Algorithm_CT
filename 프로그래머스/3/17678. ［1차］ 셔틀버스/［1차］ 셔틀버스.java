import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        int standard = 9*60;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        Bus[] busInfo = new Bus[n];
        
        for(String time : timetable){
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]) * 60;
            int minute = Integer.parseInt(split[1]);
            
            pq.add(hour + minute);
        }
        
        int time = 0;
        
        for(int i=0; i<n; i++){
            int start = standard + t*i;
            int count = 0;
            time = start;
            
            while(count < m){
                if(!pq.isEmpty() && pq.peek() <= start){
                    time = pq.poll();
                    count++;
                }else {
                    break;
                }
            }
            
            busInfo[i] = new Bus(count, start, time);
        }
        
        Bus bus = busInfo[n-1];
        if(bus.boardingNumber == m) time = bus.lastTime - 1;
        else if(bus.boardingNumber < m) time = bus.arrivalTime;

        String hoursStr = String.format("%02d", time/60); 
        String minutesStr = String.format("%02d", time%60);
        answer = hoursStr + ":" + minutesStr;
        
        return answer;
    }
    
    public static class Bus{
        int boardingNumber;
        int arrivalTime;
        int lastTime;
        
        public Bus(int boardingNumber, int arrivalTime, int lastTime){
            this.boardingNumber = boardingNumber;
            this.arrivalTime = arrivalTime;
            this.lastTime = lastTime;
        }
    }
}