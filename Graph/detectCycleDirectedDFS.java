class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int x, int[] visited, int[] path){
        visited[x] = 1;
        path[x] = 1;
        for(int i:adj.get(x)){
            if(visited[i]==0){
                if(dfs(adj, i, visited, path)) return true; 
            }
            else if(path[i]==1) return true;
        }
        path[x] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] visited = new int[V];
        int[] path = new int[V];
        for(int v=0; v<V; v++){
            if(visited[v]==0) 
                if(dfs(adj, v, visited, path)) return true;
        }
        return false;
    }
} 
