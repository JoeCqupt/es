package basic.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class Maps {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<Integer, Integer>();
        map.put(1, 1);
    }
}
