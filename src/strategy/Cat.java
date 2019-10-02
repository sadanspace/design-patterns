package strategy;

public class Cat implements Comparable<Cat>{
    int wight, hight;

    public Cat(){}
    public Cat(int wight, int hight){
        this.hight = hight;
        this.wight = wight;
    }

    public int compareTo(Cat cat){
        if (hight > cat.hight) {return 1;}
        else if (hight < cat.hight) {return -1;}
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat " + this.hight + " " + this.wight;
    }
}
