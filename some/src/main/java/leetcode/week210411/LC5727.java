package leetcode.week210411;

public class LC5727 {

    public static void main(String[] args) {
        LC5727 lc = new LC5727();
        int theWinner = lc.findTheWinner(6, 5);
        System.out.println(theWinner);
    }

    public int findTheWinner(int n, int k) {
        // 模拟
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        boolean[] exist = new boolean[n];
        int current = n; //当前游戏人数


        int idx = 0; // 当前index
        int cnt = 1; // 当前计数

        while (current > 1) {

            while (cnt < k) {
                if (exist[(idx+1)%n] == false) {
                    cnt++;
                    idx = ++idx % n;
                } else {
                    idx = ++idx % n;
                }
            }
            exist[idx] = true;
            current--;
            if (current == 1) {
                break;
            } else {
                cnt = 1;
                for (int i = ++idx; ; i++) {
                    i = i % n;
                    if (exist[i] == false) {
                        idx = i;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (exist[i] == false) return arr[i];
        }
        return -1;
    }

}
