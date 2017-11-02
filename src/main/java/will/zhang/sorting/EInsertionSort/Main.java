package will.zhang.sorting.EInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/10/31 0031 18:16.
 */
public class Main {

    public static void main(String[] args) {
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSortPerformance("will.zhang.sorting.EInsertionSort.SelectionSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.sorting.EInsertionSort.InsertionSort", arr2);
    }
}
