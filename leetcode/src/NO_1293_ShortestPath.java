import java.util.LinkedList;
import java.util.Queue;

public class NO_1293_ShortestPath {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        //非法参数处理
        if (validateInputParams(k, m, n)) {
            return -1;
        }

        //特殊场景处理
        if (m == 1 && n == 1) {
            return 0;
        }

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                visited[i][j] = -1;
            }
        }

        int minSteps = 0;

        visited[0][0] = k;
        Queue<Point> queue = new LinkedList<>();
        Point startPoint = new Point(0, 0, 0);
        queue.offer(startPoint);

        //定义四个方向移动坐标
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            minSteps ++;

            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Point current = queue.poll();
                int x = current.x;
                int y = current.y;
                int oneCount = current.oneCount;

                for (int j = 0; j < 4; j ++) {
                    int xNew = x + dx[j];
                    int yNew = y + dy[j];

                    //越界判断
                    if (xNew < 0 || xNew >= m || yNew < 0 || yNew >= n) {
                        continue;
                    }

                    //搜索到目标节点直接返回结果,按层级就是最短步数
                    if (xNew == m -1  && yNew == n -1) {
                        return minSteps;
                    }

                    //穿越障碍次数已满
                    if (grid[xNew][yNew] == 1 && oneCount >= k) {
                        continue;
                    }

                    int oneCountNew = grid[xNew][yNew] == 1 ? oneCount + 1 : oneCount;

                    //剪枝 - 节点已被访问过,且当前visited记录的剩余障碍物消除次数 >= 当前搜索节点层级的剩余消除次数
                    if (visited[xNew][yNew] != -1 && visited[xNew][yNew] >= k - oneCountNew) {
                        continue;
                    } else {
                        //否则, 贪心将最优值更新,并将该层级节点入队
                        visited[xNew][yNew] = k - oneCountNew;
                    }

                    queue.offer(new Point(xNew, yNew, oneCountNew));
                }
            }
        }

        return -1;
    }

    private boolean validateInputParams(int k , int m, int n) {
        return m > 40 || m < 1 || n > 40 || n < 1 || k < 1 || k > m * n;
    }

    class Point {
        int x;
        int y;
        int oneCount;

        public Point(int x, int y, int oneCount) {
            this.x = x;
            this.y = y;
            this.oneCount = oneCount;
        }
    }

}
