class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public void dfs(char[][] board, int[][] visited, int r, int c){
        visited[r][c] = 1;
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(board, visited, nr, nc);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        for(int j=0; j<m; j++){
            if(board[0][j]=='O' && visited[0][j]==0){
                dfs(board, visited, 0, j);
            }
            if(board[n-1][j]=='O' && visited[n-1][j]==0){
                dfs(board, visited, n-1, j);
            }
        }
        for(int i=0; i<n; i++){
            if(board[i][0]=='O' && visited[i][0]==0)
                dfs(board, visited, i, 0);
            if(board[i][m-1]=='O' && visited[i][m-1]==0)
                dfs(board, visited, i, m-1);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
    }
}
