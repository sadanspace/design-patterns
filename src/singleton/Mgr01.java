package singleton;

/*
* 饿汉式
* 类加载到内存时，就实例化了一个单例，JVM保证其线程安全
* 缺点: 在不使用该对象时，也会将其加载到内存中
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr011 = Mgr01.getInstance();
        System.out.println(mgr01 == mgr011);
    }

}
