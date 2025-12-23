class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int v, Stack<Integer> st){
        visited[v] = 1;
        for(int x:adj.get(v)){
            if(visited[x]==0)
                dfs(adj, visited, x, st);
        }
        st.push(v);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int v=0; v<V; v++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i]==0)
                dfs(adj, visited, i, st);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
}
