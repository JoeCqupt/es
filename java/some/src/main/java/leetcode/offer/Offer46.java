package leetcode.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 枚举法：列出所有的可能
 */
public class Offer46 {
    public static void main(String[] args) {
        Offer46 offer = new Offer46();
        int i = offer.translateNum(12258);
        System.out.println(i);
    }

    public int translateNum(int num) {
        List<Integer> list = splitNum(num);
        System.out.println(list);
        genStrs(list, 0);
        return cnt;
    }

    int cnt = 0;

    private void genStrs(List<Integer> list, int idx) {
        if (idx == list.size()) {
            cnt++;
            return;
        }

        if (idx < list.size() - 1) {

            genStrs(list, idx + 1);

            if(list.get(idx)!=0) {
                int v = list.get(idx) * 10 + list.get(idx + 1);
                if (v < 26) {
                    genStrs(list, idx + 2);
                }
            }
        } else {
            genStrs(list, idx + 1);
        }
    }

    private List<Integer> splitNum(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        while (num / 10 >= 1) {
            list.addFirst(num % 10);
            num = num / 10;
        }
        list.addFirst(num);
        return list;
    }

}
