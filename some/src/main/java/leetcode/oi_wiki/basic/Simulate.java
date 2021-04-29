package leetcode.oi_wiki.basic;

/**
 * 模拟
 */
public class Simulate {

    // q1: 一只一英寸的蠕虫位于 n 英寸深的井的底部。
    //它每分钟向上爬 u 英寸，但是必须休息一分钟才能再次向上爬。
    //在休息的时候，它滑落了 d 英寸。
    //之后它将重复向上爬和休息的过程。蠕虫爬出井口花费了多长时间？
    //我们将不足一分钟的部分算作一整分钟。
    //如果蠕虫爬完后刚好到达井的顶部，我们也设作蠕虫已经爬出井口。

    public int costOfTime(int n, int u, int d) {
        if (n <= u) return 1;
        int time = 0;
        int dis = 0;
        while (dis < n) {
            if (time > 0) {
                dis = dis - d;
                time++;
            }
            dis = dis + u;
            time++;
        }
        return time;
    }
}
