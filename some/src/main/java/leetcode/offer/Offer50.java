package leetcode.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50 {

    public static void main(String[] args) {
        Offer50 offer = new Offer50();
        offer.firstUniqChar("leetcode");
    }
    public char firstUniqChar(String s) {
        if(s == null || s.length()==0) return ' ';

        Map<Character,Integer> countMap = new LinkedHashMap<>();
        for(int i = 0; i <s.length(); i++){
            char charAt = s.charAt(i);
            countMap.put(charAt, countMap.getOrDefault(charAt,0)+1);
        }

       for(Map.Entry<Character,Integer> entry: countMap.entrySet()){
           if (entry.getValue()==1){
               return entry.getKey();
           }
       }
        return ' ';
    }
}
