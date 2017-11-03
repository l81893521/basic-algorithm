package will.zhang.sorting.FInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/10/31 0031 18:16.
 */
public class Main {

    public static void main(String[] args) {
        /*
        随机范围生成指定大小数组
         */
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

//        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
//
//        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.SelectionSort", arr1);
//        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.InsertionSort", arr2);
//        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.BubbleSort", arr3);

        /*
        生成接近于有序的数组
         */
        System.out.println("Test for nearly ordered array, size = " + N);

        Integer[] arra1 = SortTestHelper.generateNearlyOrderedArray(N, 5);
        Integer[] arra2 = Arrays.copyOf(arra1, arra1.length);
        Integer[] arra3 = Arrays.copyOf(arra1, arra1.length);
        Integer[] arra4 = Arrays.copyOf(arra1, arra1.length);

        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.SelectionSort", arra1);
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.InsertionSort", arra2);
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.BubbleSort", arra3);
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.BubbleSort2", arra4);
    }
}
