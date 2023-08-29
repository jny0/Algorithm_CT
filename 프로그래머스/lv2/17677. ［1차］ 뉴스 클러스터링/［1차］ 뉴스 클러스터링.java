import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int totalSize = 0;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<str1.length() -1; i++){
            String str = str1.toLowerCase().substring(i, i+2);
            if(str.matches("^[a-z]*$")){
                list1.add(str);
            }
        }

        for(int i=0; i<str2.length() -1; i++){
            String str = str2.toLowerCase().substring(i, i+2);
            if(str.matches("^[a-z]*$")){
                list2.add(str);
            }
        }
        
        double interactionSize = 0;
        double unionSize = 0;

        for (String s : list1) {
            if(list2.remove(s)){
                interactionSize++;
            }
            unionSize++;
        }

        for (String s : list2) {
            unionSize++;
        }
        
        if(unionSize <= 0) return 65536;
        
        return (int) (interactionSize/unionSize * 65536);
    }
}