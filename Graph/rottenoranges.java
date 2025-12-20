class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int days = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int r = grid.length;
        int c = grid[0].length;
        while(!q.isEmpty()){
            int[] orange = q.poll();
            int row = orange[0];
            int col = orange[1];
            int time = orange[2];
            for(int k=0; k<4; k++){
                if(row+dx[k]>=0 && col+dy[k]>=0 && row+dx[k]<r && col+dy[k]<c && grid[row+dx[k]][col+dy[k]]==1){
                    fresh--;
                    days = time+1;
                    q.add(new int[]{row+dx[k], col+dy[k], time+1});
                    grid[row+dx[k]][col+dy[k]] = 2;
                }
            }
        }
        return fresh>0 ? -1:days;

    }
}
