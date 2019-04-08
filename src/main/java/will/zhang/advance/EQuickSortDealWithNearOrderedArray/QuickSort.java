package will.zhang.advance.EQuickSortDealWithNearOrderedArray;

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
    private QuickSort() { }

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
        if(r -l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

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

        /*
         * 将第0个元素,和数组里面随机一个元素交换
         * 从而避免数组接近于有序, 导致算法的树高度接近于n, 出现退化到n方的问题
         */
        SortTestHelper.swap(arr, l, (int)(Math.random() * (r - l + 1) + l));

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
        SortTestHelper.testSortPerformance("will.zhang.advance.EQuickSortDealWithNearOrderedArray.QuickSort", arr2);

        //生成一个接近于有序的数组
        int swap = 100;
        Integer[] arr11 = SortTestHelper.generateNearlyOrderedArray(N, swap);
        Integer[] arr12 = Arrays.copyOf(arr11, arr11.length);
        System.out.println("对接近有序的数组进行测试, size = " + N );
        /**
         * 经过优化后, 排序接近于有序的数组也不会退化到N方级别
         */
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr11);
        SortTestHelper.testSortPerformance("will.zhang.advance.EQuickSortDealWithNearOrderedArray.QuickSort", arr12);

        //生成一个范围很小的数组
        Integer[] arr21 = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr22 = Arrays.copyOf(arr21, arr21.length);
        System.out.println("对范围很小(具有大量重复元素)的数组进行测试, size = " + N );
        /**
         * 但是又出现了另外一个问题
         * 当数组范围过小, 意味着有大量重复元素情况下
         * 算法又退回到O(n2)级别了
         */
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr21);
        SortTestHelper.testSortPerformance("will.zhang.advance.EQuickSortDealWithNearOrderedArray.QuickSort", arr22);
    }
}
