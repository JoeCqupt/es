package leetcode.offer;

public class Offer05 {

    public String replaceSpace(String s) {
        String replace = "%20";
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '){
                sb.append(replace);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
