package will.zhang.advance.DQuickSort;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/15 0015 17:11.
 * 快速排序
 */
public class QuickSort {
    /**
     * 不允许产生实例
     */
    private QuickSort() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        quickSort(arr, 0, n-1);
    }

    /**
     * 对arr[l...r]进行快速排序
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(Comparable[] arr, int l, int r){
        if(l >= r) return;

        int p = partition(arr, l , r);

        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);
    }

    /**
     * 对arr[l...r]部分进行partition操作
     * @param arr
     * @param l
     * @param r
     * @return 返回p, 使得arr[l..p-1] < arr[p] ; arr[p+1...r] > arr[p]
     */
    private static int partition(Comparable[] arr, int l, int r){

        Comparable v = arr[l];

        //arr[l+1...j] < v ; arr[j+i...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(v) < 0){
                SortTestHelper.swap(arr, j+1, i);
                j++;
            }
        }
        SortTestHelper.swap(arr, l, j);

        return j;
    }

    public static void main(String[] args) {
        int N = 1000000;
        System.out.println("对随机数组进行测试, size = " + N + " , 数字大小范围 [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.advance.DQuickSort.QuickSort", arr2);
        //生成一个接近于有序的数组
        int swap = 100;
        System.out.println("对接近有序的数组进行测试, size = " + N );
        Integer[] arr3 = SortTestHelper.generateNearlyOrderedArray(N, swap);
        Integer[] arr4 = Arrays.copyOf(arr3, arr3.length);
        /**
         * 可以看到如果一个接近于有序的数组,使用快速排序,所消耗的时间是惊人的
         * 因为当一个接近于有序的数组,每次都选择最左侧的元素作为标定点
         * 那么树的高度就会接近于n
         * 从而退化成为一个时间复杂度为n方的算法
         *
         * 注意:如果出现stackOverFlowError,请调大堆栈大小-Xss
         */
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr3);
        SortTestHelper.testSortPerformance("will.zhang.advance.DQuickSort.QuickSort", arr4);
    }
}
