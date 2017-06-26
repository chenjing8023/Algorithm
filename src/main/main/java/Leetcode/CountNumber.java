package Leetcode;

import java.util.Arrays;

/**
 * Created by hadoop on 17-6-6.
 */

//求逆序对数

    /**
     * 面值为 1 的最小硬币数 : 1
     面值为 2 的最小硬币数 : 2
     面值为 3 的最小硬币数 : 3
     面值为 4 的最小硬币数 : 4
     面值为 5 的最小硬币数 : 1
     面值为 6 的最小硬币数 : 2
     面值为 7 的最小硬币数 : 3
     面值为 8 的最小硬币数 : 4
     面值为 9 的最小硬币数 : 5
     面值为 10 的最小硬币数 : 1
     面值为 11 的最小硬币数 : 2
     面值为 12 的最小硬币数 : 3
     面值为 13 的最小硬币数 : 4
     面值为 14 的最小硬币数 : 5
     面值为 15 的最小硬币数 : 2
     面值为 16 的最小硬币数 : 3
     面值为 17 的最小硬币数 : 4
     面值为 18 的最小硬币数 : 5
     面值为 19 的最小硬币数 : 6
     面值为 20 的最小硬币数 : 2
     面值为 21 的最小硬币数 : 1
     面值为 22 的最小硬币数 : 2
     面值为 23 的最小硬币数 : 3
     面值为 24 的最小硬币数 : 4
     面值为 25 的最小硬币数 : 1
     面值为 26 的最小硬币数 : 2
     面值为 27 的最小硬币数 : 3
     面值为 28 的最小硬币数 : 4
     面值为 29 的最小硬币数 : 5
     面值为 30 的最小硬币数 : 2
     面值为 31 的最小硬币数 : 2
     面值为 32 的最小硬币数 : 3
     面值为 33 的最小硬币数 : 4
     面值为 34 的最小硬币数 : 5
     面值为 35 的最小硬币数 : 2
     面值为 36 的最小硬币数 : 3
     面值为 37 的最小硬币数 : 4
     面值为 38 的最小硬币数 : 5
     面值为 39 的最小硬币数 : 6
     面值为 40 的最小硬币数 : 3
     面值为 41 的最小硬币数 : 3
     面值为 42 的最小硬币数 : 2
     面值为 43 的最小硬币数 : 3
     面值为 44 的最小硬币数 : 4
     面值为 45 的最小硬币数 : 3
     面值为 46 的最小硬币数 : 2
     面值为 47 的最小硬币数 : 3
     面值为 48 的最小硬币数 : 4
     面值为 49 的最小硬币数 : 5
     面值为 50 的最小硬币数 : 2
     面值为 51 的最小硬币数 : 3
     面值为 52 的最小硬币数 : 3
     面值为 53 的最小硬币数 : 4
     面值为 54 的最小硬币数 : 5
     面值为 55 的最小硬币数 : 3
     面值为 56 的最小硬币数 : 3
     面值为 57 的最小硬币数 : 4
     面值为 58 的最小硬币数 : 5
     面值为 59 的最小硬币数 : 6
     面值为 60 的最小硬币数 : 3
     面值为 61 的最小硬币数 : 4
     面值为 62 的最小硬币数 : 4
     面值为 63 的最小硬币数 : 3
     * **/
public class CountNumber {
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        for(int i = 1;i<=money;i++)
            coinsUsed[i] = -1;
        for(int i = 1;i<valueKinds;i++)
            coinsUsed[values[i]] = 1;
        // 对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {

            // 当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = Integer.MAX_VALUE;

            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < valueKinds; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents && coinsUsed[cents - values[kind]]!=-1) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            coinsUsed[cents] = minCoins == Integer.MAX_VALUE?-1:minCoins;

            System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
                    + coinsUsed[cents]);
        }
    }

    public static void main(String[] args) {

        // 硬币面值预先已经按降序排列
        int[] coinValue = new int[] { 3,4};
        // 需要找零的面值
        int money = 8;
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[money + 1];

        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }

}
