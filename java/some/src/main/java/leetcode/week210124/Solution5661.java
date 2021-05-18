package leetcode.week210124;

public class Solution5661 {

    public static void main(String[] args) {
        Solution5661 solution = new Solution5661();
        String res = solution.maximumTime("2?:?0");
        System.out.println(res);
    }

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c=='?'){
                switch (i){
                    case 0:
                        chars[i] = (chars[1]<'4'|| chars[1]=='?')?'2':'1';
                        break;
                    case 1:
                        chars[i] = chars[0] == 2?'3':'9';
                        break;
                    case 3:
                        chars[i] = '5';
                        break;
                    default:
                        chars[i] = '9';
                }
            }
        }
        return  String.valueOf(chars);
    }
}
