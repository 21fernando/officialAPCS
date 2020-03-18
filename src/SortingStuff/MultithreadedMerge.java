package SortingStuff;

import java.util.Arrays;

public class MultithreadedMerge {

    public static void main(String[] args) {
        int[] large = new int[10];
        for (int i = 0; i < large.length; i++) {
            large[i] = (int) (Math.random() * 10000);
        }
        System.out.println(Arrays.toString(large));
        Worker w = new Worker(large);
        w.mergeSort(large);
        System.out.println(Arrays.toString(w.getPersonal()));
    }

}
