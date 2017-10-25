package will.zhang.sorting.BSelectSortUsingComparable;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 不允许产生实例
     */
    private SelectionSort() {
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 8, 7, 10, 6, 3, 0, 2, 1, 4};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
