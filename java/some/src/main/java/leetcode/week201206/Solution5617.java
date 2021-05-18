package leetcode.week201206;


import java.util.Deque;
import java.util.LinkedList;

public class Solution5617 {

    public static void main(String[] args) {
        Solution5617 solution5617 = new Solution5617();
        String interpret = solution5617.interpret("G()(al)");
        System.out.println(interpret);
    }

    public String interpret(String command) {
        char[] chars = command.toCharArray();

        Deque<Character> stack = new LinkedList<>();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (!stack.isEmpty() && c != ')') {
                stack.push(c);
                continue;
            }
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (c == ')') {

                stack.push(c);

                StringBuilder temp = new StringBuilder();

                char pop;
                while (!stack.isEmpty() && ((pop = stack.peekFirst()) != '(')) {
                    temp.append(stack.pop());
                }
                if (stack.isEmpty()) {
                    result.append(temp);
                } else {
                    temp.append(stack.pop());
                    if (temp.toString().equals(")(")) {
                        stack.push('o');
                    }
                    if (temp.toString().equals(")la(")) {
                        stack.push('l');
                        stack.push('a');
                    }
                    while (!stack.isEmpty()) {
                        result.append(stack.poll());
                    }
                }

                continue;
            }

            result.append(c);
        }

        return result.toString();
    }


}
