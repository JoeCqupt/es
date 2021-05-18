package leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution1496 {
    public static void main(String[] args) {
       Solution1496 solution =  new Solution1496();

        System.out.println(solution.isPathCrossing("NESWW"));
    }
    public boolean isPathCrossing(String path) {
        Set<Point> historySet = new HashSet<>();
        int x = 0;
        int y = 0;
        historySet.add(new Point(0,0));
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);

            switch (direction) {
                case 'N':
                    if (!historySet.add(new Point(x, ++y)))
                        return true;
                    break;
                case 'S':
                    if (!historySet.add(new Point(x, --y)))
                        return true;
                    break;
                case 'W':
                    if (!historySet.add(new Point(--x, y)))
                        return true;
                    break;
                case 'E':
                    if (!historySet.add(new Point(++x, y)))
                        return true;
                    break;
            }
        }
        return false;
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
