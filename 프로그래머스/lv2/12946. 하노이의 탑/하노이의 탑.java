
class Solution {
    static int count = 0;
    static int[][] answer;
    public int[][] solution(int n) {
        answer = new int[(int)(Math.pow(2,n)-1)][2];
        
        Hanoi(n, 1, 2, 3);
        
        return answer;
    }

    public static void Hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            answer[count][0] = start;
            answer[count][1] = end;
            count++;
            return;
        }

        Hanoi(n - 1, start, end, mid);
        answer[count][0] = start;
        answer[count][1] = end;
        count++;
        Hanoi(n - 1, mid, start, end);
    }
}