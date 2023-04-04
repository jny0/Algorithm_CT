import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine() + " ";

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '<') {     // '<'이 열리면 '>'이 닫힐 때 까지 출력
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                for (int j = i; j < str.length(); j++) {
                    bw.write(str.charAt(j));
                    i++;
                    if (str.charAt(j) == '>') {
                        break;
                    }

                }
            } else if (str.charAt(i) == ' ') { // 
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                bw.write(str.charAt(i));
                i++;
            } else {
                stack.push(str.charAt(i));
                i++;
            }
        }
        bw.flush();
        br.close();
    }
}
