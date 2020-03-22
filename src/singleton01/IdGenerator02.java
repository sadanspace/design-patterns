package singleton01;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式，支持懒加载
 *
 * 相比于饿汉式，懒汉式支持懒加载，需要实例的时候，才去创建。
 * 使用方法级加锁，来保证线程安全，但是由此，每次获取单例时，并行度很低，效率不高。
 */

public class IdGenerator02 {

    private static IdGenerator02 instance;
    private AtomicLong id = new AtomicLong(0);

    private IdGenerator02(){};

    public static synchronized IdGenerator02 getInstance(){
        if (instance == null){
            instance = new IdGenerator02();
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {

        System.out.println(IdGenerator02.getInstance() == IdGenerator02.getInstance());

    }
}
