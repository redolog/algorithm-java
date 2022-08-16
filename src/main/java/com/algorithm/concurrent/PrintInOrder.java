package com.algorithm.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. Print in Order
 * Suppose we have a class:
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 * <p>
 * Note:
 * <p>
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 * <p>
 * Input: nums = [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums is a permutation of [1, 2, 3].
 * <p>
 * https://leetcode.cn/problems/print-in-order/
 *
 * @author dragonsong  @date 2022/8/15
 */
public class PrintInOrder {

    static class FooCAS {

        AtomicInteger lock;

        public FooCAS() {
            lock = new AtomicInteger(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            lock.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (lock.get() != 1) {

            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (lock.get() != 2) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    static class FooNotifySynchronized {
        // 当前线程执行wait()方法时，会释放当前的锁，然后让出CPU，进入等待状态
        // wait需获取当前object.monitor 的owner权限，因此使用 synchronized 包裹

        // 用于执行 wait、notify
        final Object notify;
        // int变量用于控制顺序
        int seq;

        public FooNotifySynchronized() {
            notify = new Object();
            seq = 0;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (notify) {
                if (seq == 3) {
                    Thread.currentThread().stop();
                }
                while (seq != 0) {
                    notify.wait();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                seq = 1;
                // 唤醒其他所有线程
                notify.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (notify) {
                if (seq == 3) {
                    Thread.currentThread().stop();
                }
                while (seq != 1) {
                    // 只要1没执行完，这里就继续wait
                    notify.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                seq = 2;
                notify.notify();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (notify) {
                while (seq != 2) {
                    // 只要2没执行完，这里就继续wait
                    notify.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                seq = 3;
                Thread.currentThread().stop();
            }
        }
    }

    static class FooSemaphore {

        // s1给第一个线程用
        Semaphore s1;
        // s2给第二个线程用
        Semaphore s2;

        public FooSemaphore() {
            s1 = new Semaphore(0);
            s2 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            s1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // first执行结束前阻塞等待
            s1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            s2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // second执行结束前阻塞等待
            s2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    static class FooCountDownLatch {

        // 底层是aqs的sync，用于多线程间的异步转同步操作，特别适用于计数场景
        // CountDownLatch 定义了获取、释放共享资源逻辑，其中的共享资源是一个int计数值
        CountDownLatch cnt1, cnt2;

        public FooCountDownLatch() {
            cnt1 = new CountDownLatch(1);
            cnt2 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            cnt1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            cnt1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cnt2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cnt2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    static class FooSynchronousQueue {

        // 利用 SynchronousQueue 的阻塞功能，编排本题的顺序
        SynchronousQueue<Boolean> blockingQ1, blockingQ2;

        public FooSynchronousQueue() {
            blockingQ1 = new SynchronousQueue<>();
            blockingQ2 = new SynchronousQueue<>();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            blockingQ1.put(true);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // 等待first offer之后，这里才会放行
            // 注意这里不能用poll，poll默认不等待
            blockingQ1.take();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            blockingQ2.put(true);
        }

        public void third(Runnable printThird) throws InterruptedException {
            blockingQ2.take();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    static class FooLockCondition {
        /**
         * lock保证一次只有一个线程进入函数
         * seq condition保证执行顺序、不到时等待
         */

        // 标记状态
        int seq;
        // 不同seq状态对应的condition，用于线程唤醒、wait
        Condition c1, c2;
        // 配合condition的锁，condition的wait、signal操作前提是需先获得锁权限
        Lock lock;

        public FooLockCondition() {
            lock = new ReentrantLock();
            c1 = lock.newCondition();
            c2 = lock.newCondition();
            seq = 0;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                seq = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (seq != 1) {
                    c1.await();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                seq = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (seq != 2) {
                    c2.await();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                seq = 3;
            } finally {
                lock.unlock();
            }
        }
    }

    static class FooThreadPark {

        // LockSupport 封装了park/unpark 方法，用于指定线程的暂停、唤醒
        int seq;
        // 指向执行 second、third 任务的两个线程
        Thread t2, t3;

        public FooThreadPark() {
            seq = 0;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            seq = 1;
            LockSupport.unpark(t2);
            LockSupport.unpark(t3);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            t2 = Thread.currentThread();
            while (seq != 1) {
                LockSupport.park(t2);
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            seq = 2;
            LockSupport.unpark(t3);
        }

        public void third(Runnable printThird) throws InterruptedException {
            t3 = Thread.currentThread();
            while (seq != 2) {
                LockSupport.park(t3);
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
