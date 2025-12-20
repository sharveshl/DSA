class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public void dfs(int[][] image, int r, int c, int source, int color){
        image[r][c] = color;
        for(int i=0; i<4; i++){
            int nx = r+dx[i];
            int ny = c+dy[i];
            if(nx>=0 && ny>=0 && nx<image.length && ny<image[0].length && image[nx][ny]==source){
                dfs(image, nx, ny, source, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]!=color)
            dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
}
