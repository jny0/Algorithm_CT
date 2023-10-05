import java.util.*;
class Solution {
    static String[] arr;
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        arr = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();
        recursion(word, "", 0);
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }    
        
        return answer;
    }
    
    static void recursion(String word, String str, int depth){
        list.add(str);
        
        if(depth == arr.length) return;
        
        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
}