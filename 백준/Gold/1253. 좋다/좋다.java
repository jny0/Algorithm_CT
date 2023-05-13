
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {

            int left = 0;
            int right = N - 1; // 음수값이 있으므로 전체 범위

            while (left < right) {
                long sum = arr[left] + arr[right];

                if (sum == arr[i]) {

                    if(left == i) left++;
                    else if(right == i) right--;
                    else{
                        count++;
                        break;
                    }

                } else if (sum < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        System.out.println(count);
    }
}
