import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] requiredCount = new int[4];
    static int[] currentCount = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dnaLength = Integer.parseInt(st.nextToken());
        int substringLength = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < requiredCount.length; i++) {
            requiredCount[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < substringLength; i++) {
            currentCount[dnaToIndex(dna.charAt(i))]++;
        }
        if(isValidSubstring()) answer++;


        for (int right = substringLength; right < dnaLength; right++) {
            int left = right-substringLength;
            currentCount[dnaToIndex(dna.charAt(right))]++;
            currentCount[dnaToIndex(dna.charAt(left))]--;

            if(isValidSubstring()) answer++;
        }

        System.out.println(answer);
    }

    public static int dnaToIndex(char a){
        int index = 0;
        switch(a){
            case 'A' :
                index =  0;
                break;
            case 'C' :
                index =  1;
                break;
            case 'G' :
                index =  2;
                break;
            case 'T' :
                index =  3;
                break;
        }
        return index;
    }

    public static boolean isValidSubstring() {

        for (int i = 0; i < 4; i++) {
            if(requiredCount[i] > currentCount[i]){
                return false;
            }
        }

        return true;
    }
}