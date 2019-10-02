package singleton;

/**
 * 01的不同写法
 */

public class Mgr02 {
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02(){}

    public static Mgr02 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 mgr02 = Mgr02.getInstance();
        Mgr02 mgr021 = Mgr02.getInstance();
        System.out.println(mgr02 == mgr021);
    }
}
