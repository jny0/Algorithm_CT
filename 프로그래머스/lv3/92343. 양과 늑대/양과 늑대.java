import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] tree;
    static int count = 1;
    static int maxCount = 1;
    public int solution(int[] info, int[][] edges) {

        int N = info.length;

        tree = new ArrayList[info.length];

        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++){
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0; i<N; i++){
            Collections.sort(tree[i]);
        }

        System.out.println(Arrays.toString(tree));

        visited = new boolean[N];

        BFS(info, 0);

        return maxCount;
    }

    static void BFS(int[] info, int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            for(int i : tree[now_Node]){
                if(!visited[i]){
                    if(info[i] == 0) {
                        count++;
                        maxCount++;
                    }
                    else if (info[i] == 1) count--;
                    visited[i] = true;
                    queue.add(i);
                }

            }

            if(queue.isEmpty() && count <= 0){
                break;
            }
        }
    }
}