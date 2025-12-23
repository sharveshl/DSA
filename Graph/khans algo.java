class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int v=0; v<V; v++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int x = q.poll();
            ans.add(x);
            for(int i:adj.get(x)){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }
        return ans;
    }
}
