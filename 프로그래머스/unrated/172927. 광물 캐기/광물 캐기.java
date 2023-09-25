import java.util.*;
class Solution {
    static int[][] scoreBoard;
    static List<Mineral> list;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        list = new ArrayList<>();
        scoreBoard = new int[][]{{1,1,1},{5,1,1},{25,5,1}};

        int totalPick = Arrays.stream(picks).sum();
        for(int i=0; i<minerals.length; i+=5){
            if(totalPick == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            int index = 0;
            for(int j=i; j<i+5; j++){
                if(j == minerals.length) break;
                
                String mineral = minerals[j];
                if(mineral.equals("diamond")) index = 0;
                else if(mineral.equals("iron")) index = 1;
                else index = 2;
                
                dia += scoreBoard[0][index];
                iron += scoreBoard[1][index];
                stone += scoreBoard[2][index];
            }
            list.add(new Mineral(dia, iron, stone));
            totalPick--;
        }
        
        Collections.sort(list);
        
        for(Mineral m : list){
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;
            
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }    
        }
        
        return answer;
    }
    
     static class Mineral implements Comparable<Mineral>{
        private int diamond;
        private int iron;
        private int stone;
        
        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
         
        public int compareTo(Mineral m){
            return m.stone - this.stone;
        }
    }
}