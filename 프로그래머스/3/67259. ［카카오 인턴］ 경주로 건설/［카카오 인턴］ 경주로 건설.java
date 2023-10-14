import java.util.*;

class Solution {
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0}; // 좌우상하
    static int[] dy = {0, 0, 1, -1};
    static int n;

    public int solution(int[][] board) {
        n = board.length;
        visited = new int[n][n][4];

        return bfs(0, 0, -1, 0, board);
    }

    public static int bfs(int x, int y, int dir, int cost, int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, dir, cost));

        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.x == n-1 && now.y == n-1){
                minCost = Math.min(minCost, now.cost);
            }

            for (int d = 0; d < 4; d++) {
                int moveX = now.x + dx[d];
                int moveY = now.y + dy[d];

                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n || board[moveX][moveY] == 1) {
                    continue;
                }
                int nextCost = now.cost;

                // 처음노드이거나 이전과 같은 방향인 경우에만 직선도로 건설 그 외에는 코너 건설
                if(now.dir == -1 || now.dir == d) nextCost+=100;
                else nextCost+=600;

                if(visited[moveX][moveY][d] == 0 || board[moveX][moveY] >= nextCost){
                    queue.add(new Node(moveX, moveY, d, nextCost));
                    visited[moveX][moveY][d] = 1;
                    board[moveX][moveY] = nextCost;
                }
            }
        }
        return minCost;
    }

    public static class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}