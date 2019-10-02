package singleton;

/**
 * 04版优化
 * <p>
 * 使用双重验证，实现单例，线程安全，加锁的同时，效率最高
 *
 * 最开始还未初始化实例之前，在多线程情况，使用内部的锁来保证单例的生成。
 * 而在之后，则只需使用外部的普通校验就可以保证单例，从而优化了速度。
 */

public class Mgr06 {
    private static Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }

            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance());
            }).start();
        }
    }
}
