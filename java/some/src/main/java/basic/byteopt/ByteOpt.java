package basic.byteopt;

public class ByteOpt {

    public static void main(String[] args) {
        // 是除以2的5次方
        System.out.println(64 >>> 5);

        // 异或
        int i1 = 1;
        int i2 = 3;
        System.out.println(~(i1&i2) & (i1 | i2) );
        System.out.println(i1 ^ i2);

    }
}
