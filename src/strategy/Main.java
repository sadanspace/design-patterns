package strategy;

import java.util.Arrays;

/**
 * 策略模式
 * Comparable: compareTo接口，实现比较
 * Compartor: compare接口，基于不同的比较策略，进行比较
 *
 * 猫基于不同的属性进行比较，也也可以基于不同属性的组合进行比较猫的大小，这些不同的比较方式的实现就是策略模式的实现。
 */

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Cat[] cats = new Cat[3];
        cats[0] = new Cat(1,2);
        cats[1] = new Cat(2,1);
        cats[2] = new Cat(3,3);

        Dog[] dogs = {new Dog(2), new Dog(3), new Dog(1)};

        sorter.sort(cats, new CatWightComparator());
        System.out.println(Arrays.toString(cats));

        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(dogs, (o1, o2)->{
            if (o1.food > o2.food) return 1;
            else if (o1.food < o2.food) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(dogs));
    }
}
