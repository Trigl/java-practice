package ink.baixin.java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: ThreadLocal Demo：获取线程 ID
 * @Author: Baixin
 * @Create: 2019-09-17 01:02:50
 **/
public class ThreadId {
    // ID 生成器
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // 包含线程 ID 的 ThreadLocal 变量
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // 获取当前线程 ID
    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                System.out.println("线程:" + Thread.currentThread().getName() + ", ID:" + ThreadId.get());
            });

            t.start();
        }
    }
}
