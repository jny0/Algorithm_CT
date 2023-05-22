import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
            
        int[] arr = new int[tangerine[tangerine.length-1]+1];
        
        
        for(int i=0; i<tangerine.length; i++){
            arr[tangerine[i]]++;
        }
        
        List<Node> list = new ArrayList<>();
        
        for(int i=1; i<arr.length; i++){
            list.add(new Node(i, arr[i]));
        }       
        
        Collections.sort(list);
        
        int count = 0;
        for(int i=0; i<list.size(); i++){
            count+=list.get(i).count;
            answer++;
            if(count>=k) break;
        }       
        
        return answer;
    }
    
}

class Node implements Comparable<Node>{
    int size;
    int count;
    
    public Node(int size, int count){
        this.size = size;
        this.count = count;
    }
    
    @Override    
    public int compareTo(Node o) {
        return Integer.compare(o.count, this.count);
    }
    
}