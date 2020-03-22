package singleton01;

/**
 * 使用静态内部类完成
 *
 * 静态内部类的属性不会再类加载时初始化，符合懒加载，而其线程安全性由final关键字控制，也就是JVM来保证
 *
 */

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator04 {

    private static AtomicLong id = new AtomicLong(0);

    private IdGenerator04(){}

    private static class IdGenerator {
        private static final IdGenerator04 instance = new IdGenerator04();
    }

    public static IdGenerator04 getInstance(){
        return IdGenerator.instance;
    }

    public static long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator04.getInstance() == IdGenerator04.getInstance());
    }
}
