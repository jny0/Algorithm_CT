
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int[] count = new int[4];
        int[] checkCount = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count.length; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = 0;
        int right = P-1;

        String dna = str.substring(left, right);
        for (int i = 0; i < P-1; i++) {
            checkCount[dnaCheck(dna.charAt(i))]++;
        }


        while(right != S){
            checkCount[dnaCheck(str.charAt(right))]++;
            boolean check = true;

            for (int i = 0; i < 4; i++) {
                if(count[i] > checkCount[i]){
                    check = false;
                    break;
                }
            }

            if(check == true) answer++;

            checkCount[dnaCheck(str.charAt(left))]--;
            left++;
            right++;
        }

        System.out.println(answer);

    }

    public static int dnaCheck(char a){
        int result = 0;
        switch(a){
            case 'A' :
                result =  0;
                break;
            case 'C' :
                result =  1;
                break;
            case 'G' :
                result =  2;
                break;
            case 'T' :
                result =  3;
                break;
        }
        return result;
    }

}
