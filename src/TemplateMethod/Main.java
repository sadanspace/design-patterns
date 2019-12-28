package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
    }
}


abstract class T {
    void start(){
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}


class T1 extends T{
    @Override
    void op1() {
        System.out.println("T1 op1");
    }

    @Override
    void op2() {
        System.out.println("T2 op2");
    }
}
