class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] res = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = 1;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            res[r][c] = d;
            for(int k=0; k<4; k++){
                int nr = r+dx[k];
                int nc = c+dy[k];
                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==0){
                    vis[nr][nc] = 1;
                    q.add(new int[]{nr, nc, d+1});
                }
            }
        }
        return res;
    }
}
