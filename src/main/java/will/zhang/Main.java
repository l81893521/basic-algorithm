package will.zhang;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/10/31 0031 18:16.
 */
public class Main {

    public static void main(String[] args) {
        /*
        随机范围生成指定大小数组
         */
        int N = 1000000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSortPerformance("will.zhang.advance.AMergeSort.MergeSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.heap.DHeapify.HeapSort", arr2);
        SortTestHelper.testSortPerformance("will.zhang.heap.DHeapify.HeapSort2", arr3);
        SortTestHelper.testSortPerformance("will.zhang.heap.EHeapSort.HeapSort3", arr4);

        /*
        生成接近于有序的数组
         */
        System.out.println("Test for nearly ordered array, size = " + N);
//
        arr1 = SortTestHelper.generateNearlyOrderedArray(N, 5);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSortPerformance("will.zhang.advance.AMergeSort.MergeSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.heap.DHeapify.HeapSort", arr2);
        SortTestHelper.testSortPerformance("will.zhang.heap.DHeapify.HeapSort2", arr3);
        SortTestHelper.testSortPerformance("will.zhang.heap.EHeapSort.HeapSort3", arr4);

        /*
        测试存在包含大量相同元素的数组
         */
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSortPerformance("will.zhang.advance.AMergeSort.MergeSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.heap.DHeapify.HeapSort", arr2);
        SortTestHelper.testSortPerformance("will.zhang.heap.DHeapify.HeapSort2", arr3);
        SortTestHelper.testSortPerformance("will.zhang.heap.EHeapSort.HeapSort3", arr4);



    }
}
