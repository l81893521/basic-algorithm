package will.zhang.advance.FQuickSort2Ways;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/17 0017 18:44.
 * 双路快速排序
 * 快速排序的第一种写法
 */
public class QuickSort {

    /**
     * 不允许产生实例
     */
    private QuickSort() {
    }

    public static void sort(Comparable[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * 对arr[l...r]进行快速排序
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(Comparable[] arr, int l, int r){

        //数组小规模数组使用快速排序
        if(r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l , r);

        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);

    }

    /**
     * 双路快速排序的partition
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

        int i = l + 1, j = r;

        while (true){
            /*
            注意这里的
            arr[i].compareTo(v) < 0 和 arr[j].compareTo(v) > 0
            不能是
            arr[i].compareTo(v) <= 0 和 arr[j].compareTo(v) >= 0
            因为当一个数组范围非常小,会出现大量重复元素
            从而导致树的严重不平衡
             */
            while(i <= j && arr[i].compareTo(v) < 0) i++;
            while(j >= i && arr[j].compareTo(v) > 0) j--;

            SortTestHelper.swap(arr, i, j);
            if(i > j){
                break;
            }
            i++;
            j--;
        }
        SortTestHelper.swap(arr, l, j);

        return j;
    }



    public static void main(String[] args) {
        int N = 100000;
        //生成一个随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSortPerformance("will.zhang.advance.EQuickSortDealWithNearOrderedArray.QuickSort", arr);

        //生成一个接近于有序的数组
        int swap = 100;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, swap);
        SortTestHelper.testSortPerformance("will.zhang.advance.EQuickSortDealWithNearOrderedArray.QuickSort", arr1);

        //生成一个范围很小的数组
        Integer[] arr2 = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSortPerformance("will.zhang.advance.FQuickSort2Ways.QuickSort", arr2);
    }
}
