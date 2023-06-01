

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < N; i++) {
            if(max < arr[i].index -i){
                max = arr[i].index -i;
            }
        }

        System.out.println(max + 1);

    }
}

class Node implements Comparable<Node> {

    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
