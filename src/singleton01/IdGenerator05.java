package singleton01;

/**
 * 使用枚举类的特征
 */

import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator05{
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    private long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator05.INSTANCE == IdGenerator05.INSTANCE);
    }
}
