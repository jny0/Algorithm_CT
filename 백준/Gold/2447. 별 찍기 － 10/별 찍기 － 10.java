
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] starArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        starArr = new char[N][N];

        for(int i=0; i<starArr.length; i++) {
            Arrays.fill(starArr[i],' ');
        }

        star(0, 0, N);

        for(int i=0; i<starArr.length; i++) {
            System.out.println(starArr[i]);
        }
    }

    public static void star(int x, int y, int N) {
        if(N == 1) {
            starArr[x][y] = '*';
            return;
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i == 1 && j == 1) {
                    continue;
                } else {
                    star(x+((N/3)*i), y+((N/3)*j), (N/3));
                }
            }
        }
    }
}
