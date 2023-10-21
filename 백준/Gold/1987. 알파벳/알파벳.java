
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Character[][] map;
    static boolean[][] visited;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int r, c, max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new Character[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String next = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = next.charAt(j);
            }
        }
        
        List<Character> alphabets = new ArrayList<>();
        alphabets.add(map[0][0]);

        dfs(0, 0, alphabets);

        System.out.println(max);
    }

    public static void dfs(int x, int y, List<Character> alphabets) {

        max = Math.max(max, alphabets.size());

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveY < 0 || moveX >= r || moveY >= c || visited[moveX][moveY]) continue;

            if (!alphabets.contains(map[moveX][moveY])) {
                visited[moveX][moveY] = true;
                alphabets.add(map[moveX][moveY]);
                dfs(moveX, moveY, alphabets);
                alphabets.remove(map[moveX][moveY]);
                visited[moveX][moveY] = false;
            }
        }
    }

}
