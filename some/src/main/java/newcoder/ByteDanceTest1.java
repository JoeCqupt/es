package newcoder;

import java.util.Scanner;

/**
 * 字节跳动 测开应届 牛客网测评题一
 * 未通过 通过率50%
 */
public class ByteDanceTest1 {
    public static void main(String[] args) {
        ByteDanceTest1 test = new ByteDanceTest1();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(test.exchange(s));
    }
    public String exchange(String str){
        if(str == null || str.length()==0) return str;
        char offset = str.charAt(0);
        int off = 0;
        if(offset>='A' && offset <='Z'){
            // 表示是字母
            off = offset - 'A' + 1;
        }else if(offset >='0' && offset<= '9'){
            // 表示是数字
            off = offset - '0';
        }else {
            // 表示是其他字符
            off = 1;
        }
        if(off == 0){
            return str;
        }
        char[] chars = new char[str.length()];
        int idx = 0;
        for(int i = 0; i< str.length(); i++){
            char charAt = str.charAt(i);
            if(charAt>='A' && charAt <='Z'){
                // 处理
                char c = (char) ((charAt - 'A' + off) % 26 + 'A');
                chars[idx++] = c;

            }else if(charAt >='0' && charAt<= '9'){
                // 处理
                char c = (char) ((charAt - '0' + off) % 10 + '0');
                chars[idx++] = c;
            }else {
                chars[idx++] = charAt;
            }
        }

        return String.valueOf(chars);
    }

}
