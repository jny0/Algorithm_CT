import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				char char1 = s1.charAt(n);
                char char2 = s2.charAt(n);
                
                if(char1 != char2){
                    return Character.compare(char1, char2);
                }
                return s1.compareTo(s2);
                
			}
		});
        
        
        return strings;
    }
}