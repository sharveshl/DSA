class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public void dfs(int[][] board, int[][] visited, int r, int c){
        visited[r][c] = 1;
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==0 && board[nr][nc]==1){
                dfs(board, visited, nr, nc);
            }
        }
    }
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        for(int j=0; j<m; j++){
            if(board[0][j]==1 && visited[0][j]==0){
                dfs(board, visited, 0, j);
            }
            if(board[n-1][j]==1 && visited[n-1][j]==0){
                dfs(board, visited, n-1, j);
            }
        }
        for(int i=0; i<n; i++){
            if(board[i][0]==1 && visited[i][0]==0)
                dfs(board, visited, i, 0);
            if(board[i][m-1]==1 && visited[i][m-1]==0)
                dfs(board, visited, i, m-1);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && board[i][j]==1)
                    count+=1;
            }
        }
        return count;
    }
}
