package leetcode.middle.s3_tree;

/**
 * 并查集的解法
 */
public class LC200_2 {

    public static void main(String[] args) {
        LC200_2 lc = new LC200_2();

        int i = lc.numIslands(
                new char[][]
                        {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            rank = new int[row * col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * col + j] = i * col + j;
                        count++;
                    }
                }
            }
        }

        public int find(int index) {
            if (parent[index] != index)
                parent[index] = find(parent[index]);
            return parent[index];
        }

        public void union(int index1, int index2) {
            int p1 = find(index1);
            int p2 = find(index2);
            if (p1 != p2) {
                if (rank[p1] > rank[p2]) {
                    parent[p2] = p1;
                } else if (rank[p1] < rank[p2]) {
                    parent[p1] = p2;
                } else {
                    parent[p1] = p2;
                    rank[p2]++;
                }
                count--;
            }
        }
    }

    public int numIslands(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 0; // 修改此节点
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(col * i + j, col * (i - 1) + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        uf.union(col * i + j, col * (i + 1) + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(col * i + j, col * i + j - 1);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        uf.union(col * i + j, col * i + j + 1);
                    }

                }
            }
        }

        return uf.count;
    }

}
