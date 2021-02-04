package leetcode.array;

import java.util.Arrays;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int i = board.length;
        int j = board[0].length;
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                int aliveCnt = countArround(m, n, board, i, j);
                boolean alive = board[m][n] == 1;
                if (alive) {
                    if (aliveCnt < 2) {
                        board[m][n] = board[m][n] | 0b00;
                    }
                    if (aliveCnt >= 2 && aliveCnt <= 3) {
                        board[m][n] = board[m][n] | 0b10;
                    }
                    if (aliveCnt > 3) {
                        board[m][n] = board[m][n] | 0b00;
                    }
                } else {
                    if (aliveCnt == 3) {
                        board[m][n] = board[m][n] | 0b10;
                    }
                }
            }
        }

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                board[m][n] = board[m][n] >>> 1;
            }
        }
    }

    /**
     * 计算附近 生存的细胞
     *
     * @param m
     * @param n
     * @param board
     * @param i
     * @param j
     * @return
     */
    private int countArround(int m, int n, int[][] board, int i, int j) {
        int result = 0;
        if (m - 1 >= 0 && n - 1 >= 0) {
            result += (board[m - 1][n - 1] & 1);
        }
        if (m - 1 >= 0) {
            result += (board[m - 1][n] & 1);
        }

        if (m - 1 >= 0 && n + 1 < j) {
            result += (board[m - 1][n + 1] & 1);
        }

        if (n - 1 >= 0) {
            result += (board[m][n - 1] & 1);
        }
        if (n + 1 < j) {
            result += (board[m][n + 1] & 1);
        }

        if (m + 1 < i && n - 1 >= 0) {
            result += (board[m + 1][n - 1] & 1);
        }
        if (m + 1 < i) {
            result += (board[m + 1][n] & 1);
        }
        if (m + 1 < i && n + 1 < j) {
            result += (board[m + 1][n + 1] & 1);
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameOfLife().gameOfLife(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
