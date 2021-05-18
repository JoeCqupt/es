package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典的N皇后问题 ，使用回溯算法
 */
public class Solution51 {

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println("---------------");
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("---------------");
        }
    }

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] table = new char[n][n];
        //初始化tempResult
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            for (int j = 0; j < n; j++) {
                chars[j] = '.';
            }
            table[i] = chars;
        }

        trick(table, 0);
        return result;
    }

    private void trick(char[][] table, int row) {
        if (row == table.length) {
            result.add(genStr(table));
            return;
        }
        char[] cols = table[row];
        for (int i = 0; i < cols.length; i++) {
            if (!isValid(table, row, i)) {
                continue;
            }
            table[row][i] = 'Q';

            trick(table, row + 1);
            table[row][i] = '.';
        }
    }

    private boolean isValid(char[][] table, int row, int col) {
        // 检查列
        for (int i = 0; i < table.length; i++) {
            if (table[i][col] == 'Q') {
                return false;
            }
        }
        // 检查行
        for (char r : table[row]) {
            if (r == 'Q') {
                return false;
            }
        }
        // 检查斜
        // 左下和 右下 是不用检查，因为我们是从上往下填的，所以下面肯定是没有皇后Q
        boolean leftUp = true;
        boolean rightUp = true;
        int i = 1;
        int n = table.length;
        while (leftUp || rightUp) {
            if (leftUp) {
                int r1 = row - i;
                int c1 = col - i;
                if (inN(r1, c1, n)) {
                    if (table[r1][c1] == 'Q') {
                        return false;
                    }
                } else {
                    leftUp = false;
                }
            }

            if (rightUp) {
                int r1 = row - i;
                int c1 = col + i;
                if (inN(r1, c1, n)) {
                    if (table[r1][c1] == 'Q') {
                        return false;
                    }
                } else {
                    rightUp = false;
                }
            }
            i++;
        }
        return true;
    }

    private boolean inN(int r, int c, int n) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }


    private List<String> genStr(char[][] table) {
        List<String> strList = new ArrayList<>();
        for (char[] chars : table) {
            strList.add(String.valueOf(chars));
        }
        return strList;
    }


}
