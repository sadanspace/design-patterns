package strategy;

public class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2){
        if(dog1.food > dog2.food) return 1;
        if(dog1.food < dog2.food) return -1;
        return 0;
    }
}
