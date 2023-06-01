import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        int[] arr = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if(max < arr[j]){
                    max = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = max;
            arr[index] = temp;

            sb.append(max);
        }

        System.out.println(sb.toString());
    }
}
