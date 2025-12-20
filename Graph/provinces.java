class Solution {
    
    public void bfs(int[][] isConnected, boolean[] visited, int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<isConnected.length; i++){
                if(isConnected[x][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;
        for(int v=0; v<isConnected.length; v++){
            if(!visited[v]){
                provinces++;
                bfs(isConnected, visited, v);
            }
        }
        return provinces;
    }
}