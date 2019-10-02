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

    //sort(int)

    void swap(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
