package strategy;

import java.util.Arrays;

/**
 * 策略模式
 * Comparable
 * Compartor
 */

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Cat[] cats = new Cat[3];
        cats[0] = new Cat(1,2);
        cats[1] = new Cat(2,1);
        cats[2] = new Cat(3,3);

        Dog[] dogs = {new Dog(2), new Dog(3), new Dog(1)};

        sorter.sort(cats);
        System.out.println(Arrays.toString(cats));

        sorter.sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }
}
