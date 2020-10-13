public class NO_200_NumIslands {

    class UnionFind {


        // 这里的count 就是我们要求的岛屿数量, 也是并集的数量
        int count;
        // 用来存储元素及连接关系的数组
        int[] parent;
        // 权重表, 存储数组中每一个元素的权重, 即该节点的子节点数量
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            //将二维数组转化成一维数组, 并初始化parent和rank数组
            parent = new int[m * n];
            rank = new int[m * n];

            for (int i = 0; i < m; ++ i) {
                for(int j = 0; j < n; ++ j) {
                    // 如果该节点值为1, 代表该节点是根节点, 将id的值存入, 并count ++
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++ count;
                    }
                    // 初始化每一个节点的权重为0
                    rank[i * n + j] = 0;
                }
            }

        }

        // 查找一个元素的根节点位置, 这里使用到路径压缩
        // i 为当前节点, parent[i] 为父节点
        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            // 找到两个节点的根节点
            int rootx = find(x);
            int rooty = find(y);
            // 如果根节点不同, 则代表x和y没有连接
            if (rootx != rooty) {
                //将x和y所在的两棵树进行合并, 小树放到大树下面
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                // x 和 y并不是孤立的岛, 需要合并
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        // 非空判断
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 初始化UF类
        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        UnionFind uf = new UnionFind(grid);

        for (int r = 0; r < nr; ++ r) {
            for (int c = 0; c < nc; ++ c) {
                //如果是岛,则向四个方向探索,并做范围判断; 同时连接两个岛
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
