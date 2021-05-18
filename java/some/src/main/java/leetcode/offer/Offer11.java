package leetcode.offer;

public class Offer11 {

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 < numbers.length) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            }
        }
        return numbers[0];
    }

}
