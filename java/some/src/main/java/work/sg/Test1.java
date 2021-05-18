package work.sg;


public class Test1 {

    public static void main(String[] args) {
        Test1 test = new Test1();

        int i = test.buildRoom(
                new int[][]
                        {
                                {2, 2},
                                {0, 4},
                                {6, 2}
                        }
        );
        System.out.println(i);
    }

    public int buildRoom(int[][] params) {
        int[] first = params[0];
        int rooms = first[0];
        int w = first[1]; // 新房间的边长

//        Collections.sort(params, 1, params.length);
        int result = 2;
        for (int i = 1; i < params.length; i++) {
            if (i + 1 < params.length) {
                if(params[i+1][0] - params[i][0] >= (params[i+1][1]/2 + params[i][1]/2 + w)){
                    result++;
                }
            }
        }
        return result;
    }
}
