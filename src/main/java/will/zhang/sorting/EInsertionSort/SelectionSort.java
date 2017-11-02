package will.zhang.sorting.EInsertionSort;

import will.zhang.sorting.DSelectionSortDetectPerformance.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/10/31 0031 16:13.
 * 测试选择排序的性能
 */
public class SelectionSort {

    /**
     * 不允许产生实例
     */
    private SelectionSort(){}

    /**
     * 选择排序
     * @param arr
     */
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0){
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //测试选择排序的性能
        Integer[] arr = will.zhang.sorting.DSelectionSortDetectPerformance.SortTestHelper.generateRandomArray(10000, 0, 100000);
        SortTestHelper.testSortPerformance("will.zhang.sorting.EInsertionSort.SelectionSort", arr);
//        System.out.println(Arrays.toString(arr));
    }
}
