
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        while (true) {
           sb.append(dq.pollFirst()).append(" ");
           if(dq.isEmpty()) break;
           dq.offerLast(dq.pollFirst());
        }

        System.out.println(sb);


    }
}
