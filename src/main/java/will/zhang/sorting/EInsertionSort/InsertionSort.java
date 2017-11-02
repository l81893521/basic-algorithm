package will.zhang.sorting.EInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/10/31 0031 17:27.
 * 插入排序
 */
public class InsertionSort {

    /**
     * 不允许产生实例
     */
    private InsertionSort(){};

    /**
     * 插入排序
     * 未经过优化
     * @param arr
     */
    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                swap(arr, j, j-1);
            }
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //排序测试
        Integer[] arr = SortTestHelper.generateRandomArray(20000,0,20000);
        SortTestHelper.testSortPerformance("will.zhang.sorting.EInsertionSort.InsertionSort", arr);
//        System.out.println(Arrays.toString(arr));
    }
}

