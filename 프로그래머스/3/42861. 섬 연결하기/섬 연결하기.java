import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int final_cost = 0;

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i=0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            if (find(a) != find(b)) {
				union(a, b);
				final_cost += cost;
			}
        }
        
        
        return final_cost;
    }
    
    private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}

}