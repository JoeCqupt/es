package leetcode.week201227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution5210 {
    public int[] findBall(int[][] grid) {
        int row = grid.length;

        int col = grid[0].length;

        List<Item> items = new LinkedList<>();
        // init
        for (int k = 0; k < col; k++) {
            items.add(new Item(0, k, k));
        }
        List<Item> removeList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            int[] cols = grid[i];
            if (items.isEmpty()) {
                break;
            }
            for (Item item : items) {
                // 左边界限
                int j = item.j;
                if (j == 0) {
                    if (grid[i][j] == -1) {
                        removeList.add(item);
                        continue;
                    }
                }
                // 右边界
                if (j == col - 1) {
                    if (grid[i][j] == 1) {
                        removeList.add(item);
                        continue;
                    }
                }
                if (grid[i][j] == 1 && grid[i][j + 1] == -1) {
                    removeList.add(item);
                }
                if (grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    item.j = j + 1;
                }
                if (grid[i][j] == -1 && grid[i][j - 1] == 1) {
                    removeList.add(item);
                }
                if (grid[i][j] == -1 && grid[i][j - 1] == -1) {
                    item.j = j - 1;
                }
            }
            if (!removeList.isEmpty()) {
                for (Item item : removeList) {
                    items.remove(item);
                }
                removeList.clear();
            }
        }
        int[] res = new int[col];
        Arrays.fill(res, -1);

        for (Item item : items) {
            res[item.index] = item.j;
        }
        return res;
    }

    static class Item {
        int i;
        int j;
        int index;

        public Item(int i, int j, int index) {
            this.i = i;
            this.j = j;
            this.index = index;
        }
    }
}