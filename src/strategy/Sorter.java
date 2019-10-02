package strategy;

public class Sorter {
    public void sort(Cat[] cats) {
        for(int i=0; i<cats.length - 1; i++) {
            int minPos = i;

            for(int j=i+1; j<cats.length; j++) {
                minPos = cats[j].compareTo(cats[minPos]) == -1 ? j : minPos;
            }
            swap(cats, i, minPos);
        }
    }

    public void sort(Dog[] dogs) {
        for(int i=0; i<dogs.length - 1; i++) {
            int minPos = i;

            for(int j=i+1; j<dogs.length; j++) {
                minPos = dogs[j].compareTo(dogs[minPos]) == -1 ? j : minPos;
            }
            swap(dogs, i, minPos);
        }
    }

    void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
