package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();

        while (x / 10 > 0) {
            list.add(x % 10);
            x = x / 10;
        }
        list.add(x % 10);

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
