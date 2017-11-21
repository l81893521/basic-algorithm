package will.zhang.advance.AMergeSort;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/14 0014 16:34.
 */
public class Main {

    public static void main(String[] args) {
        /*
        随机范围生成指定大小数组
         */
        int N = 20000;

        /*
        生成接近于有序的数组
        */
        System.out.println("Test for nearly ordered array, size = " + N);

        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 5);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        /**
         * 可以看到
         * 在没有经过优化的MergeSort
         * 对接近于有序的数组(或者完全有序的数组)进行排序
         * MergeSort比InsertionSort慢了不少
         */
        SortTestHelper.testSortPerformance("will.zhang.basic.FInsertionSort.InsertionSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.advance.AMergeSort.MergeSort", arr2);
    }
}
