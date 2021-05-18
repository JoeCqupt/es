package work.sg;


import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String cellstring = test2.getCellstring(256);
        System.out.println(cellstring);
    }

    public String getCellstring(int value) {
        if (value <= 0) {
            return null;
        }
        List<Character> res = new ArrayList<>();
        int div = 0;
        while (value / 26 > 0) {
            div = value % 26;
            value = value / 26;
            if (value >= 26) {
                res.add('z');
            } else {
                res.add((char) ('a' + (value - 1)));
            }
        }
        if (div != 0) {
            res.add((char) ('a' + (div - 1)));
        }
        StringBuilder sb = new StringBuilder();
        res.forEach(v -> sb.append(v));
        return sb.toString();
    }
}
