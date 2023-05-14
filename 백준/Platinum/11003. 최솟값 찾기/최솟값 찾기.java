
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            while(!dq.isEmpty() && dq.peekLast() > arr[i]){
                dq.pollLast();
            }
            dq.addLast(arr[i]);
            sb.append(dq.peekFirst()).append(" ");
        }

        for (int i = M; i < N; i++) {
            if (dq.peekFirst() == arr[i-M]) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.peekLast() > arr[i]){
                dq.pollLast();
            }
            dq.addLast(arr[i]);
            sb.append(dq.peekFirst()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
