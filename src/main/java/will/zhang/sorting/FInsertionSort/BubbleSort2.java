package will.zhang.sorting.FInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/1 0001 18:52.
 */
public class BubbleSort2 {

    /**
     * 不允许产生实例
     */
    private BubbleSort2() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if(arr[i-1].compareTo(arr[i]) > 0){
                    SortTestHelper.swap(arr, i-1, i);
                    swapped = true;
                }
            }
            //每经过一轮循环,最后的元素可以忽略,属于优化项
            n--;
        }while(swapped);
    }

    public static void main(String[] args) {
        int N = 3;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr = {1, 9, 2};
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.BubbleSort2", arr);
//        System.out.println(Arrays.toString(arr));
    }
}
