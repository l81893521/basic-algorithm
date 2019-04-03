package will.zhang.basic.DSelectionSortDetectPerformance;

import will.zhang.util.SortTestHelper;

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
                    SortTestHelper.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        //测试选择排序的性能
        Integer[] arr = SortTestHelper.generateRandomArray(20000, 0, 20000);
        SortTestHelper.testSortPerformance("will.zhang.basic.DSelectionSortDetectPerformance.SelectionSort", arr);
    }
}
