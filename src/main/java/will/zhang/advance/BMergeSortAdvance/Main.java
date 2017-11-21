package will.zhang.advance.BMergeSortAdvance;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/14 0014 16:50.
 */
public class Main {
    public static void main(String[] args) {
        /*
        随机范围生成指定大小数组
         */
        int N = 50000;

        /*
        生成接近于有序的数组
        */
        System.out.println("Test for nearly ordered array, size = " + N);

        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 5);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        /*
        在接近于有序的数组上
        经过优化后的MergeSort性能.已经和InsertionSort差不多了
         */
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.InsertionSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr2);
    }
}
