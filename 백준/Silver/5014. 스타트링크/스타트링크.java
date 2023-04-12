
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int floor = Integer.parseInt(str[0]);
        int start = Integer.parseInt(str[1]);
        int end = Integer.parseInt(str[2]);
        int up = Integer.parseInt(str[3]);
        int down = Integer.parseInt(str[4]);

        int[] arr = new int[floor + 1];
        System.out.println(BFS(floor, start, end, up, down, arr));
    }

    static String BFS(int floor, int start, int end, int up, int down, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        arr[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == end) {
                return String.valueOf(arr[current] - 1);
            }
            if (current + up <= floor) {
                if(arr[current+up] ==0){
                    arr[current+up] = arr[current]+1;
                    q.add(current + up);
                }
            }
            if(current - down >0) {
                if(arr[current-down] ==0){
                    arr[current-down] = arr[current]+1;
                    q.add(current - down);
                }
            }

        }

        return "use the stairs";
    }

}
