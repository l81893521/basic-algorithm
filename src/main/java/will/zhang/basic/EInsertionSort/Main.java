package will.zhang.basic.EInsertionSort;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/10/31 0031 18:16.
 */
public class Main {

    public static void main(String[] args) {
        int N = 20000;
        System.out.println("对随机数组进行测试, size = " + N + " , 数字大小范围 [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSortPerformance("will.zhang.basic.EInsertionSort.SelectionSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.basic.EInsertionSort.InsertionSort", arr2);
    }
}
