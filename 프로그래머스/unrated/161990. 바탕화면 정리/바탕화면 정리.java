import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    xList.add(j);
                    yList.add(i);
                }
            }
        }
        
        int minX = Collections.min(xList);
        int minY = Collections.min(yList);
        int maxX = Collections.max(xList) + 1;
        int maxY = Collections.max(yList) + 1;

        return new int[]{minY, minX, maxY, maxX};
    }
}