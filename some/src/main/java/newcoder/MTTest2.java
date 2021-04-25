package newcoder;

import java.util.Comparator;
import java.util.TreeSet;

public class MTTest2 {

    static class Item {
        int idx; //新闻index
        int hot; //新闻热度
    }

    public static void main(String[] args) {
        TreeSet<Item> itemSet = new TreeSet<>(
                new Comparator<Item>() {
                    @Override
                    public int compare(Item i1, Item i2) {
                        if (i1.hot != i2.hot) { // 如果热度不相等 按照热度排序
                            return i1.hot - i2.hot;
                        } else { //如果热度相等 按照索引排序
                            return i1.idx - i2.hot;
                        }
                    }
                }
        );

        // 读取输入
        Item newItem = null;// 新读取的行
        if (itemSet.contains(newItem)) { //如果已经在集合内，先移除
            itemSet.remove(newItem);
        }
        itemSet.add(newItem);

    }
}
