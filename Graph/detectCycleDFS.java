import java.util.*;

class Solution {

    private boolean dfs(int node, int parent,ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, node, adj, visited))
                    return true;
            } 
            else if (neigh != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }
}
