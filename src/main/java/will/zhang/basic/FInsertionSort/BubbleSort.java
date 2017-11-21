package will.zhang.basic.FInsertionSort;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/1 0001 15:59.
 */
public class BubbleSort {

    /**
     * 不允许产生实例
     */
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            //减去i是因为最后的元素可以不再考虑,属于优化项
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0){
                    SortTestHelper.swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSortPerformance("will.zhang.basic.FInsertionSort.BubbleSort", arr);
        System.out.println(Arrays.toString(arr));
    }
}
