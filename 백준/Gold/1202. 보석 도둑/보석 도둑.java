import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewelArr = new Jewel[N];
        int[] bagWeight = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.valueOf(st.nextToken());
            int price = Integer.valueOf(st.nextToken());
            jewelArr[i] = new Jewel(weight, price);
        }

        for (int i = 0; i < K; i++) {
            bagWeight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelArr);
        Arrays.sort(bagWeight);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int idx = 0;
        for (int i = 0; i < bagWeight.length; i++) {
            while (idx < N && jewelArr[idx].weight <= bagWeight[i]){
                pq.offer(jewelArr[idx].price);
                idx++;
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }

        System.out.println(sum);

    }
    static class Jewel implements Comparable<Jewel> {
        private int weight;
        private int price;

        public Jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
