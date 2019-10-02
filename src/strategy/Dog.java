package strategy;

public class Dog implements Comparable<Dog>{
    int food;

    public Dog(){}
    public Dog(int food) {
        super();
        this.food = food;
    }

    public int compareTo(Dog dog){
        if (food > dog.food) {return 1;}
        else if (food < dog.food) {return -1;}
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog " + this.food;
    }
}
