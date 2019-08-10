package by.vlad.strategy.Sort;

import java.util.Arrays;

class InsertingSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Inserting sort");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for(int barier = 1;barier < arr.length;barier++){
            int index = barier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]){
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}
