import java.util.*;

public class Test {

    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = edges.length;

        int[] parent = new int[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i ++) {
            parent[i] = i;
        }

        for (int i = 0; i < nodeCount; i ++) {
            int[] edge = edges[i];

            int node1 = edge[0], node2 = edge[1];

            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public void union(int[] parent, int node1, int node2) {
        parent[find(parent, node1)] = parent[find(parent, node2)];
    }

}
