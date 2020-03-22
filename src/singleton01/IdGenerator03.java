package singleton01;

/**
 * 双重检查
 *
 * 即支持懒加载，线程安全，性能上也高
 *
 * 该方法在JDK低版本时存在指令重排序所引发的创建未初始化化的对象。
 *
 */

public class IdGenerator03 {

    private IdGenerator03 instance;
    private IdGenerator03(){}

    public IdGenerator03 getInstance(){
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new IdGenerator03();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
