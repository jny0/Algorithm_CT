import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static int V;
    private static int E;
    private static int[][] distance;
    private static int INF = 10000000;
    private static int MIN = 10000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        distance = new int[V + 1][V + 1];

        // 같은 마을이 입력될 때에는 거리 0, 아니라면 INF로 일단 저장(초기화)
        for (int i = 1; i <= V; i++) {
            Arrays.fill(distance[i], INF);
        }

        // 각 마을을 연결하는 도로 저장
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            distance[a][b] = c;
        }
        floyd();

        for (int i = 1; i <= V; i++) {
            MIN = Math.min(distance[i][i], MIN);
        }
        if (MIN == INF) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }
}