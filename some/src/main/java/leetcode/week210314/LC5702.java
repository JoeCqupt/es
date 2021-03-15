package leetcode.week210314;

import java.util.HashMap;
import java.util.Map;

public class LC5702 {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = edges.length;

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==n){
                return entry.getKey();
            }
        }


        return -1;
    }

}
