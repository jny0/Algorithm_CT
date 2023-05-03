
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int L, C;
    public static char[] list;
    public static char[] code;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);

        makeCode(0,0);

    }

    public static void makeCode(int x,int idx) {
        if (idx == L) {
            if (check()) {
                System.out.println(code);
            }
            return;
        }

        for (int i = x; i < C; i++) {
            code[idx] = list[i];
            makeCode(i+1, idx + 1);
        }
    }

    public static boolean check() {
        int c = 0; // 자음의 개수
        int v = 0; // 모음의 개수

        for (char x : code) {
            if ("aeiou".indexOf(x) >= 0) {
                v++;
            } else {
                c++;
            }
        }

        if (c >= 2 && v >= 1) return true;
        return false;
    }

}