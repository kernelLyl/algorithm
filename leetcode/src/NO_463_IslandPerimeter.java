public class NO_463_IslandPerimeter {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public int islandPerimeter(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        int ans = 0;

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {

                //陆地
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k ++) {
                        int tx = j + dx[k];
                        int ty = i + dy[k];

                        if (tx < 0 || tx == m || ty < 0 || ty == n || grid[ty][tx] == 0) {
                            ans ++;
                        }
                    }
                }


            }
        }
        return ans;
    }

}
