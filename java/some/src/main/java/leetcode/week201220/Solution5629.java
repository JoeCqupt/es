package leetcode.week201220;

public class Solution5629 {

    public static void main(String[] args) {
        Solution5629 solution5629 = new Solution5629();

        System.out.println(solution5629.reformatNumber("--17-5 229 35-39475 "));
    }

    public String reformatNumber(String number) {
        String after = number.replace(" ", "").replace("-", "");

        int length = after.length();
        // 取余数的结果
        int div = length % 3;
        int left = 0;
        if (div == 1) {
            left = 4;
        } else if (div == 0) {
            left = 3;
        } else {
            left = 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < after.length(); i++) {
            if (after.length() - i == left && left == 4) {
                if(0!=i) {
                    sb.append("-");
                }
                sb.append(after.charAt(i++));
                sb.append(after.charAt(i++));
                sb.append("-");
                sb.append(after.charAt(i++));
                sb.append(after.charAt(i));
                break;
            }

            if (i != 0 & i % 3 == 0) {
                sb.append("-");
                sb.append(after.charAt(i));
            } else {
                sb.append(after.charAt(i));
            }
        }

        return sb.toString();
    }

}
