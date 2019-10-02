package singleton;

/**
 * 静态内部类的属性不会再外部类加载时就执行，只有到使用到getInstance方法时，才会执行。
 * JVM保证其线程安全，以及懒加载，实现单例
 */

public class Mgr07 {
    private Mgr07(){}

    private static class Mgr07Holder {
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr07.getInstance());
            }).start();
        }
    }
}
