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
        int N = 100000;
        //生成一个随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSortPerformance("will.zhang.advance.GQuickSort3Ways.QuickSort", arr);

        //生成一个接近于有序的数组
        int swap = 100;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, swap);
        SortTestHelper.testSortPerformance("will.zhang.advance.GQuickSort3Ways.QuickSort", arr1);

        //生成一个范围很小的数组
        Integer[] arr2 = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSortPerformance("will.zhang.advance.GQuickSort3Ways.QuickSort", arr2);
    }
}
