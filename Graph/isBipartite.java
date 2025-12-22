class Solution {
    public boolean dfs(int[][] graph, int[] colors, int v, int c){
        colors[v] = c;
        for(int neighbour:graph[v]){
            if(colors[neighbour]== -1){
                if(dfs(graph, colors, neighbour, 1-c)==false)
                    return false;
            }
            else if(colors[neighbour]==c){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i=0; i<graph.length; i++){
            if(colors[i]== -1){
                if(dfs(graph, colors, i, 0)==false)
                    return false;
            }
        }
        return true;
    }
}
