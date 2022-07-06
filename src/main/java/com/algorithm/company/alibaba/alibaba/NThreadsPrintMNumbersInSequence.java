package com.algorithm.company.alibaba.alibaba;

/**
 * 题目原型：
 * 请实现两个线程, 使之交替打印 +1+-+100, 如, 两个线程分别为: Printer1+和Printer2, 最后输出结果为
 * //+++Printer1+-+1
 * //+++Printer2+-+2
 * <p>
 * 题目进阶：N个线程顺次（按启动顺序或者名字升序）打印给定的0-M范围数
 * <p>
 * 1 M(最大值)*N(线程), 可能会变【入参化】
 * <p>
 * 2 考虑时间/空间复杂度【不借助外部容器，使用指针法遍历数据，不需要额外空间】
 * 30分钟
 *
 * @author DragonSong  @date 2021/3/13
 */
public class NThreadsPrintMNumbersInSequence {

    // m个数
    private int mNumbers;
    // n个线程
    private int nThreads;
    // 当前下标，保证多线程可见
    private volatile int cursor;

    private class PrintTask implements Runnable {
        // 线程对应分区号
        private final int partition;

        // 创建线程实例时指定分区号
        public PrintTask(int partition) {
            this.partition = partition;
        }

        @Override
        public void run() {
            while (true) {
                // 判断分区号，是自己的分区才执行
                while (cursor % nThreads != partition) {
                    // 打完了可fail-fast
                    if (cursor > mNumbers) {
                        return;
                    }
                }
                // 通过锁同步资源
                synchronized (NThreadsPrintMNumbersInSequence.class) {
                    // 打完了
                    if (cursor >= mNumbers) {
                        break;
                    }
                    // +++Printer1+-+1  下标顺移
                    cursor++;
                    System.out.println("+++" + Thread.currentThread().getName() + "+-+" + cursor);
                }
            }
        }
    }

    public void startAllTasks(int mNumbers, int nThreads) {
        // 根据入参初始化任务
        this.mNumbers = mNumbers;
        this.nThreads = nThreads;
        this.cursor = 0;
        for (int i = 0; i < nThreads; ++i) {
            // 每个线程启动各自的任务
            Thread tn = new Thread(new PrintTask(i));
            tn.setName("Printer" + (i + 1));
            tn.start();
        }
    }

    public static void main(String[] args) {
        new NThreadsPrintMNumbersInSequence().startAllTasks(1000, 10);
    }
}