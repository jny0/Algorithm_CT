
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static int max_size = 0;
    static int count = 0;
    static boolean visited[][];
    static int picture[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<Node> queue;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);

        visited = new boolean[n][m];
        picture = new int[n][m];

        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max_size);

    }

    static void bfs(int x, int y){
        visited[x][y] = true;
        queue.add(new Node(x, y));

        count++;
        int pic_size = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || picture[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
                pic_size++;
            }
        }
        max_size = Math.max(max_size, pic_size);
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
