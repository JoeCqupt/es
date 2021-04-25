package leetcode.week210328;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC5714 {

    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == '(') {
                StringBuilder sb = new StringBuilder();
                i++;
                while (i < s.length() && (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                    sb.append(s.charAt(i));
                    i++;
                }
                if (s.charAt(i) == ')') {
                    String value = map.get(sb.toString());
                    if(value == null){
                        res.append("?");
                    }else{
                        res.append(value);
                    }
                    i++;
                }else {
                    res.append("(").append(sb);
                }
            } else {
                res.append(c);
                i++;
            }
        }
        return res.toString();
    }

}
