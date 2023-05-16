
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean err = true;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 1;
        for (int i = 0; i < N; i++) {
            while (arr[i] >= num) {
                stack.push(num);
                num++;
                sb.append("+").append("\n");
            }

            if (stack.peek() == arr[i]) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                err = false;
                break;
            }

        }

        if(err) System.out.println(sb);
        else System.out.println("NO");

    }
}
