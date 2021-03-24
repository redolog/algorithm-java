package com.algorithm.dp;

/**
 * Shen 是一个财主，有一天他发现自己家的后山居然是一个金矿，目测金矿采之不竭。但Shen还没高兴多久，有关部门也得知了这个消息，决定收归国有。为了弥补shen的损失，有关部门作出以下的让步，Shen 可以获得 D 天的开采权利，在D天后，才收归国有。 为了在 D 天后剩余最多的金子，Shen 可以结合以下两种方式来采金： 1. Shen 家里有不少长工，可以发动他们去采金； 2. 城门下有很多等待和地主签卖身契的穷苦人民，Shen 在每天早上，都可以选择雇佣任意多个长工。只要一次性付给他们每人一笔费用，就可以让他们成为 Shen 家里的长工，终身为 Shen 劳动采金；假设 Shen 家里初始有 P 个长工，每个长工每天可以采得 G 块金子。初始家中的剩余金子数为 M，而每个长工雇佣需要花 C 块金子。
 * <p>
 * 问题I: 给定 D / P / G / M / C，请计算 Shen D 天后手里最多可以有多少金子
 * <p>
 * <p>
 * 要不要雇佣 x
 * 雇佣几个 y
 * <p>
 * D天
 * P个初始化长工
 * 每个长工每天可以采得 G 块金子
 * M个初始金子
 * 每个长工花费C块金子
 * <p>
 * 计算当天购买的长工挣的钱比成本高即可
 *
 * @author DragonSong  @date 2021/3/24
 */
public class CapitalistMaximumRevenue {

    public static int calculateMaximumRevenue() {
        // 入参校验，整数小数暂不考虑
        // 剩余天数
        int days = 100;
        // 初始人工
        int people = 1;
        // 每个人工单天工作收益
        int workoutDaily = 1;
        // 初始金子
        int balance = 10000;
        // 单人购买成本
        int cost = 1;

        for (int day = 1; day <= days; day++) {
            // 钱不够了下一天看看 或者 赚的钱比成本低了
            if (balance < cost || workoutDaily * (days - day + 1) <= cost) {
                balance += people * workoutDaily;
                continue;
            }
            // 目前余额最多能承担的人数
            int actualPeopleCountToday = balance / cost;
            // 人数更新
            people += actualPeopleCountToday;
            // 余额 = 减去花销 加每天可赚的钱
            balance = balance - cost * actualPeopleCountToday + people * workoutDaily;
        }

        // 最后余额即为答案
        System.out.println(balance);
        return balance;
    }
}
