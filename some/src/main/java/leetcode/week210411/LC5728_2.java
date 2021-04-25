package leetcode.week210411;


public class LC5728_2 {

    public int minSideJumps(int[] ob) {
        int n = ob.length;

        int row1 = 1;
        int row2 = 0;
        int row3 = 1;

        for (int i = 1; i < n; i++) {
            int cur1 = Integer.MAX_VALUE-1;
            int cur2 = Integer.MAX_VALUE-1;
            int cur3 = Integer.MAX_VALUE-1;
            if (ob[i] != 1) cur1 = row1;
            if (ob[i] != 2) cur2 = row2;
            if (ob[i] != 3) cur3 = row3;

            if(ob[i] != 1) cur1 = Math.min(cur1, Math.min(cur2,cur3) + 1);
            if(ob[i] != 2) cur2 = Math.min(cur2, Math.min(cur1,cur3) + 1);
            if(ob[i] != 3) cur3 = Math.min(cur3, Math.min(cur1,cur2) + 1);

            row1 = cur1;
            row2 = cur2;
            row3 = cur3;
        }
        return Math.min(Math.min(row1,row2),row3);
    }

}
