package leetcode.offer;

public class Offer13 {

    public static void main(String[] args) {
        Offer13 o = new Offer13();
        int i = o.movingCount(
                38, 15, 9
        );
        System.out.println(i);
    }

    int res = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, m, n, k, visited);
        return res;
    }

    private void dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n) {
            return;
        }
        if (sumNums(i) + sumNums(j) <= k && visited[i][j] == false) {
            res++;
            visited[i][j] = true;
            dfs(i + 1, j, m, n, k, visited);
            dfs(i, j + 1, m, n, k, visited);
        }
    }

    /**
     * 计算一个数字的各位数字之和
     */
    public int sumNums(int value) {
        int res = 0;
        while (value / 10 != 0) {
            res += value % 10;
            value = value / 10;
        }
        return res + value % 10;
    }


}
