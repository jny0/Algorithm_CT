class Solution {
    public int solution(int n) {
        int answer = 0;

        String value = Integer.toString(n, 3);

        StringBuilder sb = new StringBuilder(value);
        answer = Integer.parseInt(sb.reverse().toString(), 3);

        return answer;
    }
}