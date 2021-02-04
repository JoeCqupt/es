package leetcode.str;

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int m = 0;
        int n = s.length - 1;

        char temp;
        while (m < n) {
            if (s[m] != s[n]) {

                temp = s[m];
                s[m] = s[n];
                s[n] = temp;
            }

            m++;
            n--;
        }

    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a' , 'b', 'c'};
        new ReverseString().reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}