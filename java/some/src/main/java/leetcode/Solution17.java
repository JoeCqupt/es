package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    static Map<Character, List<Character>> mapping = new HashMap<>();

    static {
        mapping.put('2', Arrays.asList('a', 'b', 'c'));
        mapping.put('3', Arrays.asList('d', 'e', 'f'));
        mapping.put('4', Arrays.asList('g', 'h', 'i'));
        mapping.put('5', Arrays.asList('j', 'k', 'l'));
        mapping.put('6', Arrays.asList('m', 'n', 'o'));
        mapping.put('7', Arrays.asList('p', 'q', 'r', 's'));
        mapping.put('8', Arrays.asList('t', 'u', 'v'));
        mapping.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return new ArrayList<>();
        List<String> list  = new ArrayList<>(digits.length());
        StringBuilder sb = new StringBuilder();
        doCombination(list, digits, 0, sb);
        return list;
    }

    private void doCombination(List<String> list, String digits, int idx, StringBuilder sb) {
        if(digits.length()== idx){
            list.add(sb.toString());
            return;
        }
        char c = digits.charAt(idx);
        List<Character> chars = mapping.get(c);
        for(char mappingChar : chars){
            sb.append(mappingChar);
            doCombination(list, digits, idx +1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
