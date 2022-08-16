package com.algorithm.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class PrintInOrderTest {

    @Test
    public void testPrintInOrder() throws InterruptedException {
        PrintInOrder.FooCAS foo = new PrintInOrder.FooCAS();
        Runnable task2 = () -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task2).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void testPrintInOrder2() throws InterruptedException {
        PrintInOrder.FooNotifySynchronized foo = new PrintInOrder.FooNotifySynchronized();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        TimeUnit.SECONDS.sleep(5);

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        Thread.currentThread().join();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testPrintInOrder3() throws InterruptedException {
        PrintInOrder.FooSemaphore foo = new PrintInOrder.FooSemaphore();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        TimeUnit.SECONDS.sleep(5);

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        Thread.currentThread().join();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testPrintInOrder4() throws InterruptedException {
        PrintInOrder.FooCountDownLatch foo = new PrintInOrder.FooCountDownLatch();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testPrintInOrder5() throws InterruptedException {
        PrintInOrder.FooSynchronousQueue foo = new PrintInOrder.FooSynchronousQueue();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testPrintInOrder6() throws InterruptedException {
        PrintInOrder.FooLockCondition foo = new PrintInOrder.FooLockCondition();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            new Thread(() -> {
                try {
                    foo.first(() -> System.out.println("first"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testPrintInOrder7() throws InterruptedException {
        PrintInOrder.FooThreadPark foo = new PrintInOrder.FooThreadPark();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            new Thread(() -> {
                try {
                    foo.first(() -> System.out.println("first"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
    }

}