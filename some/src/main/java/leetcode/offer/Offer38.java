package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *  核心思想就是回溯法
 */
public class Offer38 {

    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        String[] res = offer38.permutation("abc");
        System.out.println(Arrays.toString(res));
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        doPermutation(s.toCharArray(), res, visited, sb);

        return res.toArray(new String[]{});
    }

    private void doPermutation(char[] toCharArray, List<String> res, boolean[] visited, StringBuilder sb) {
        if (sb.length() == toCharArray.length) {
            res.add(sb.toString());
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < toCharArray.length; i++) {
            if (!visited[i] && !set.contains(toCharArray[i])) {
                visited[i] = true;
                sb.append(toCharArray[i]);

                doPermutation(toCharArray, res, visited, sb);

                sb.deleteCharAt(sb.length()-1);
                set.add(toCharArray[i]);
                visited[i] = false;
            }
        }
    }

}
