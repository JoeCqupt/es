package newcoder;

import java.util.Random;

/**
 * 红包算法
 */
public class RedPackage {

    int remainSize; // remainSize 剩余的红包数量
    double remainMoney;   // remainMoney 剩余的钱


    public static double getRandomMoney(RedPackage _redPackage) {
        if (_redPackage.remainSize == 1) {
            _redPackage.remainSize--;
            return (double) Math.round(_redPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01; // 最小金额
        double max = _redPackage.remainMoney / _redPackage.remainSize * 2; //最大金额
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        _redPackage.remainSize--;
        _redPackage.remainMoney -= money;
        return money;
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(2354.892345423));
    }

}
