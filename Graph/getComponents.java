class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int val){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        vis[val] = true;
        q.add(val);
        ans.add(val);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int y:adj.get(x)){
                if(!vis[y]){
                    q.add(y);
                    vis[y] = true;
                    ans.add(y);
                }
            }
        }
        return ans;
    } 
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int v=1; v<=V; v++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                ans.add(bfs(adj, vis, i));
            }
        }
        return ans;
        
    }
}
