package will.zhang.advance.GQuickSort3Ways;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/20 0020 12:09.
 * 三路快速排序
 * 快速排序的第二种写法
 */
public class QuickSort {
    /**
     * 不允许产生实例
     */
    private QuickSort() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length -1;
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(Comparable[] arr, int l, int r){

        //对于较小的数组使用快速排序
        if(r - l < 16){
            InsertionSort.sort(arr, l, r);
            return;
        }


        //partition

        /*
         * 将第0个元素,和数组里面随机一个元素交换
         * 从而避免数组接近于有序, 导致算法的树高度接近于n, 出现退化到n方的问题
         */
        SortTestHelper.swap(arr, l, (int)(Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];

        int lt = l;//arr[l...lt] < v
        int gt = r + 1;//arr[gt...r] > v
        int i = l + 1;//arr[lt+1...i-1] == v

        while(i < gt){
            if(arr[i].compareTo(v) < 0){// arr[i] < v
                /*
                让当前元素归纳到arr[l...lt]中
                 */
                SortTestHelper.swap(arr, i, lt+1);
                lt++;
                i++;
            }else if(arr[i].compareTo(v) > 0){// arr[i] > v
                /*
                只需要跟gt的前一个元素交换就可以
                并且不需要i++
                因为交换后的元素还是没有经过处理的
                 */
                SortTestHelper.swap(arr, i, gt-1);
                gt--;
            }else{ // arr[i] = v
                i++;
            }
        }

        SortTestHelper.swap(arr, l, lt);

        //递归处理
        quickSort(arr, l, lt-1);
        quickSort(arr, gt, r);


    }

    public static void main(String[] args) {
        int N = 1000000;
        System.out.println("对随机数组进行测试, size = " + N + " , 数字大小范围 [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.advance.FQuickSort2Ways.QuickSort", arr2);
        SortTestHelper.testSortPerformance("will.zhang.advance.GQuickSort3Ways.QuickSort", arr3);
        long startTime = System.currentTimeMillis();
        Arrays.sort(arr4);
        long endTime = System.currentTimeMillis();
        System.out.println("JavaQuickSork:" + (endTime - startTime) + "ms");

        //生成一个接近于有序的数组
        int swap = 100;
        Integer[] arr11 = SortTestHelper.generateNearlyOrderedArray(N, swap);
        Integer[] arr12 = Arrays.copyOf(arr11, arr11.length);
        Integer[] arr13 = Arrays.copyOf(arr11, arr11.length);
        Integer[] arr14 = Arrays.copyOf(arr11, arr11.length);
        System.out.println("对接近有序的数组进行测试, size = " + N );
        /**
         * 经过优化后, 排序接近于有序的数组也不会退化到N方级别
         */
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr11);
        SortTestHelper.testSortPerformance("will.zhang.advance.FQuickSort2Ways.QuickSort", arr12);
        SortTestHelper.testSortPerformance("will.zhang.advance.GQuickSort3Ways.QuickSort", arr13);
        startTime = System.currentTimeMillis();
        Arrays.sort(arr14);
        endTime = System.currentTimeMillis();
        System.out.println("JavaQuickSork:" + (endTime - startTime) + "ms");
        //生成一个范围很小的数组
        Integer[] arr21 = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr22 = Arrays.copyOf(arr21, arr21.length);
        Integer[] arr23 = Arrays.copyOf(arr21, arr21.length);
        Integer[] arr24 = Arrays.copyOf(arr21, arr21.length);
        System.out.println("对范围很小(具有大量重复元素)的数组进行测试, size = " + N );
        /**
         * 但是又出现了另外一个问题
         * 当数组范围过小, 意味着有大量重复元素情况下
         * 算法又退回到O(n2)级别了
         */
        SortTestHelper.testSortPerformance("will.zhang.advance.BMergeSortAdvance.MergeSort", arr21);
        SortTestHelper.testSortPerformance("will.zhang.advance.FQuickSort2Ways.QuickSort", arr22);
        SortTestHelper.testSortPerformance("will.zhang.advance.GQuickSort3Ways.QuickSort", arr23);
        startTime = System.currentTimeMillis();
        Arrays.sort(arr24);
        endTime = System.currentTimeMillis();
        System.out.println("JavaQuickSork:" + (endTime - startTime) + "ms");
    }
}
