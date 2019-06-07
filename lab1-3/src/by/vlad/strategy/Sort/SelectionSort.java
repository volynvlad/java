package by.vlad.strategy.Sort;

import java.util.Arrays;

class SelectionSort implements Sorting{
    public void sort(int[] arr){
        System.out.println("Selection sort");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for(int barier = 0;barier < arr.length-1;barier++){
            for(int i = barier + 1;i < arr.length;i++){
                if(arr[i] < arr[barier]){
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}