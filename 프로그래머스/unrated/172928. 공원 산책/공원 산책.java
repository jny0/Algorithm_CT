import java.util.*;


class Solution {

    static boolean[][] map;
    static int[] xPos = {1, 0, -1, 0};
    static int[] yPos = {0, 1, 0, -1};
    public int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;

        map = new boolean[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                map[i][j] = park[i].charAt(j) != 'X';
                if (park[i].charAt(j) == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }

        for (String route : routes) {

            String[] routeSplit = route.split(" ");
            int direction = getDirectionIndex(routeSplit[0]);
            int distance = Integer.parseInt(routeSplit[1]);

            int prevX = startX;
            int prevY = startY;

            for(int i=0; i<distance; i++){
                int newX = startX + xPos[direction];
                int newY = startY + yPos[direction];

                if(newX < 0 || newY >= map.length || newY < 0 || newX >= map[0].length || !map[newY][newX]) {
                    startX = prevX;
                    startY = prevY;
                    break;
                }
                startX = newX;
                startY = newY;
            }
        }

        return new int[]{startY, startX};
    }

    public int getDirectionIndex(String direction) {
       Map<String, Integer> directionMap = Map.of("E", 0, "S", 1, "W", 2, "N", 3);
       return directionMap.get(direction);
    }

}
