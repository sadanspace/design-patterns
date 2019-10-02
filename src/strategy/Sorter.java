package strategy;

public class Sorter {
    public void sort(Comparable[] comparables, Comparator comparator) {
        for(int i=0; i<comparables.length - 1; i++) {
            int minPos = i;

            for(int j=i+1; j<comparables.length; j++) {
                minPos = comparator.compare(comparables[j], comparables[minPos]) == -1 ? j : minPos;
            }
            swap(comparables, i, minPos);
        }
    }

    void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
