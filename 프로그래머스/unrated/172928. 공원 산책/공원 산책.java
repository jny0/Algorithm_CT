class Solution {

    static boolean[][] map;
    static int[] xPos = {1, 0, -1, 0};
    static int[] yPos = {0, 1, 0, -1};
    public int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;

        map = new boolean[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            String[] parkDetail = park[i].split("");
            for (int j = 0; j < parkDetail.length; j++) {
                if (!parkDetail[j].equals("X")) {
                    map[i][j] = true;
                }

                if (parkDetail[j].equals("S")) {
                    startX = j;
                    startY = i;
                }
            }
        }

        for (String route : routes) {

            String[] routeSplit = route.split(" ");

            int way = checkDirection(routeSplit[0]);
            int distance = Integer.parseInt(routeSplit[1]);

            int[] startPos = new int[]{startX, startY};

            for(int i=0; i<distance; i++){
                int newX = startX + xPos[way];
                int newY = startY + yPos[way];

                if(newX < 0 || newY >= map.length || newY < 0 || newX >= map[0].length || !map[newY][newX]) {
                    startX = startPos[0];
                    startY = startPos[1];
                    break;
                }

                startX = newX;
                startY = newY;
            }

            startPos[0] = startX;
            startPos[1] = startY;
        }

        return new int[]{startY, startX};
    }


    public int checkDirection(String direction) {

        switch (direction) {
            case "E" -> {
                return 0;
            }
            case "S" -> {
                return  1;
            }
            case "W" -> {
                return  2;
            }
            default -> {
                return 3;
            }
        }

    }

}
