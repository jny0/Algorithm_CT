import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] checkCount = new int[4];
    static int[] count = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < checkCount.length; i++) {
            checkCount[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < P; i++) {
            count[dnaCheck(str.charAt(i))]++;
        }
        if(isValid()) answer++;


        for (int right = P; right < S; right++) {
            int left = right-P;
            count[dnaCheck(str.charAt(right))]++;
            count[dnaCheck(str.charAt(left))]--;

            if(isValid()) answer++;
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

    public static boolean isValid() {

        for (int i = 0; i < 4; i++) {
            if(checkCount[i] > count[i]){
                return false;
            }
        }

        return true;
    }

}