package leetcode.offer;

public class Offer12 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, board, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int charAt) {
        if (charAt == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        char c = word.charAt(charAt);
        if ( c == board[i][j]) {
            board[i][j] = '*';
            // 判断下一个
            boolean res = dfs(i - 1, j, board, word, charAt + 1)
                    || dfs(i + 1, j, board, word, charAt + 1)
                    || dfs(i, j - 1, board, word, charAt + 1)
                    || dfs(i, j + 1, board, word, charAt + 1);
            board[i][j] = c;
            return res;
        } else {
            return false;
        }
    }

}
