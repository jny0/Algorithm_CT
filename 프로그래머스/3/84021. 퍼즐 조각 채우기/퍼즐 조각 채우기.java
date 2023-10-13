import java.util.*;
class Solution {
    static Set<Puzzle> emptyPlaces;
    static List<Puzzle> puzzles;
    static boolean[][] visited;
    static int dx[] = {0, 1, 0, -1, 0};
    static int dy[] = {1, 0, -1, 0, 0};
    static int n;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        n = game_board.length;
        emptyPlaces = new HashSet<>();
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    Puzzle emptyPlace = bfs(i, j, game_board, 0);
                    emptyPlaces.add(emptyPlace);
                }
            }
        }

        puzzles = new ArrayList<>();
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    Puzzle puzzle = bfs(i, j, table, 1);
                    puzzles.add(puzzle);
                }
            }
        }

        for (Puzzle puzzle : puzzles) {
            Puzzle rotatedPuzzle = puzzle;
            for (int i = 0; i < 4; i++) {
                rotatedPuzzle = rotate(rotatedPuzzle);
                int count = findAndRemoveEmptyPlace(rotatedPuzzle.map);
                if (count > 0) {
                    answer += count;
                    break;
                }
            }
        }

        return answer;
    }

    public static Puzzle bfs(int x, int y, int[][] map, int target) {
        int sX = n, eX = 0, sY = n, eY = 0;

        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int moveX = node.x + dx[i];
                int moveY = node.y + dy[i];

                if (isOutOfBounds(moveX, moveY) || visited[moveX][moveY] || map[moveX][moveY] != target){
                    continue;
                }
                    
                queue.add(new Node(moveX, moveY));
                visited[moveX][moveY] = true;
                set.add(new Node(moveX, moveY));

                sX = Math.min(sX, moveX);
                sY = Math.min(sY, moveY);
                eX = Math.max(eX, moveX);
                eY = Math.max(eY, moveY);
            }
        }

        int width = eX - sX;
        int height = eY - sY;
        int[][] array = new int[width + 1][height + 1];
        for (Node node : set) {
            array[node.x - sX][node.y - sY] = 1;
        }
        return new Puzzle(array, set.size());
    }
    
    public static boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    public static Puzzle rotate(Puzzle puzzle) {
        int n = puzzle.map.length;
        int m = puzzle.map[0].length;

        int[][] rotatedPuzzle = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedPuzzle[i][j] = puzzle.map[n - 1 - j][i];
            }
        }
        return new Puzzle(rotatedPuzzle, puzzle.size);
    }

    public static int findAndRemoveEmptyPlace(int[][] rotatedPuzzle) {
        for (Puzzle emptyPlace : emptyPlaces) {
            if (Arrays.deepEquals(emptyPlace.map, rotatedPuzzle)) {
                emptyPlaces.remove(emptyPlace);
                return emptyPlace.size;
            }
        }
        return 0;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Puzzle {
        int[][] map;
        int size;

        public Puzzle(int[][] map, int size) {
            this.map = map;
            this.size = size;
        }
    }
}