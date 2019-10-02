package singleton;

/**
 * 04版优化
 *
 * 加锁的位置不对，导致单例无法实现。
 * 正确的加锁位置应该在判断实例之前或者在判断时
 */

public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05(){}

    public static Mgr05 getInstance(){
        if(INSTANCE == null){
            // 通过减少同步代码块的范围，来增加效率，结果不可行
            synchronized (Mgr05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr05.getInstance());
            }).start();
        }
    }
}
