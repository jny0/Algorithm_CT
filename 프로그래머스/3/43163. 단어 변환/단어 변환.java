class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    public static void dfs(String current, String target, String[] words, int count) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            int k = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (current.charAt(j) != words[i].charAt(j)) k++;
            }

            if (k == 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
}