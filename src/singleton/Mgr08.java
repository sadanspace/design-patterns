package singleton;

/**
 * 保证线程安全，还能防止反序列化
 * 反序列化问题：通过反射拿到内存中的类，可以进行创建新对象
 * 解决的原因：枚举类没有构造方法，因此就算拿到了也不能创建新对象
 */
public enum Mgr08 {
    INSTANCE;

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()-> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }


}
