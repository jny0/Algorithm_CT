import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(new Solution().solution(str));

        br.close();
    }
}

class Solution {
    public int solution(String str) {
        int mul = 1;
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push('(');
                mul *= 2;
            } else if( str.charAt(i) == '['){
                stack.push('[');
                mul *= 3;
            } else if( str.charAt(i) == ')'){
                if (stack.isEmpty() || stack.peek() != '(') { //올바른 문자열이 아닌 경우
                    answer = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    answer += mul;
                }
                stack.pop();
                mul /= 2;       // 닫힌 괄호에 대한(이미 계산된) 값 제외
            } else if( str.charAt(i) == ']'){
                if (stack.isEmpty() || stack.peek() != '[') { //올바른 문자열이 아닌 경우
                    answer = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    answer += mul;
                }
                stack.pop();
                mul /= 3;
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        } else {
            return answer;
        }

    }
}