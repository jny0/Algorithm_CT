import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        List<FileName> fileNames = new ArrayList<>();
    
        for(int i=0; i<files.length; i++){
            String head = files[i].split("[0-9]")[0].toLowerCase();
            int number = Integer.parseInt(files[i].substring(head.length()).split("[^0-9]")[0]);
            fileNames.add(new FileName(files[i], head, number));
        }
        
        Collections.sort(fileNames);
        
        return fileNames.stream().map(FileName::getFileName).toArray(String[]::new);
    }
    
    public class FileName implements Comparable<FileName>{
        String fileName;
        String head;
        int number;
        
        public FileName(String fileName, String head, int number){
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }
        
        public String getFileName() {
            return fileName;
        }
        
        public int compareTo(FileName f){
           int headComparison = this.head.compareTo(f.head);
            if(headComparison == 0){
                return Integer.compare(this.number, f.number);
            }
            return headComparison;
        }
        
    }
}