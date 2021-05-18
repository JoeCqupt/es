package oi_wiki;

import java.util.HashSet;
import java.util.Set;

/**
 * 枚举
 */
public class Enumerate {

    // q1: 一个数组中的数互不相同，求其中和为0 的数对的个数
    // 题目没有描述是否要求数对的顺序,如果不要求顺序这个结果*2即可
    public int coupleOfZero(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) res++;
            }
        }
        return res;
    }

    // O(n)的解法
    // 结果是有顺序的
    public int coupleOfZero2(int[] arr) {
        int res = 0;
        // 注意审题：数组中数不同
        Set<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(0-arr[i])) res++;
            set.add(arr[i]);
        }
        return res;
    }
}
