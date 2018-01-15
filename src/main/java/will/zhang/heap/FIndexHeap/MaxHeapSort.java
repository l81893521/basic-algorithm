package will.zhang.heap.FIndexHeap;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2018/1/15 0015 18:55.
 * 使用最大索引堆进行堆排序, 来验证我们的最大索引堆的正确性
 * 最大索引堆的主要作用不是用于排序, 我们在这里排序只是为了验证我们的所答索引堆实现的正确性
 */
public class MaxHeapSort {

    private MaxHeapSort(){

    }

    public static void sort(Comparable[] arr){
        int n = arr.length;

        MaxIndexHeap maxIndexHeap = new MaxIndexHeap(n);
        for (int i = 0; i < n; i++) {
            maxIndexHeap.insert(i, arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxIndexHeap.extractMax();
        }
    }

    public static void sort2(Comparable[] arr){
        int n = arr.length;

        MaxIndexHeap maxIndexHeap = new MaxIndexHeap(arr);

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxIndexHeap.extractMax();
        }
    }

    public static void main(String[] args) {

        Comparable[] arr1 = SortTestHelper.generateRandomArray(10, 0 ,9);
        Comparable[] arr2 = Arrays.copyOf(arr1, arr1.length);

        MaxHeapSort.sort(arr1);
        MaxHeapSort.sort2(arr2);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }
    }
}
