package singleton01;

/**
 * 饿汉式
 *
 * 简单易实现，静态属性，在类加载的时候就已经生成了实例，所以创建实例线程安全，但不支持懒加载。
 *
 *
 *
 */

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator01 {

    private static AtomicLong id = new AtomicLong(0);
    private final static IdGenerator01 instance = new IdGenerator01();

    private IdGenerator01(){}

    public static IdGenerator01 getInstance(){
        return instance;
    }

    public static long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator01.getInstance()== IdGenerator01.getInstance());

        System.out.println(IdGenerator01.getInstance().getId());
        System.out.println(IdGenerator01.getInstance().getId());

    }
}
