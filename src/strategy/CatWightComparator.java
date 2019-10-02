package strategy;

public class CatWightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat cat1, Cat cat2){
        if (cat1.wight > cat2.wight) return 1;
        else if (cat1.wight < cat2.wight) return -1;
        return 0;
    }
}
