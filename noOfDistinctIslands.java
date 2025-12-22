// User function Template for Java

class Solution {
    void dfs(int[][] grid, int[][] visited, int r, int c, int n, int m, StringBuilder s){
        visited[r][c] = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int k=0; k<4; k++){
            int nr = r+dx[k];
            int nc = c+dy[k];
            if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==0 && grid[nr][nc]==1){
                if(k==0) s.append('u');
                else if(k==1) s.append('r');
                else if(k==2) s.append('d');
                else s.append('l');
                dfs(grid, visited, nr, nc, n, m, s);
                s.append('b');
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    StringBuilder s = new StringBuilder();
                    s.append('s');
                    dfs(grid, visited, i, j, n, m, s);
                    set.add(s.toString());
                }
            }
        }
        return set.size();
        
    }
}
