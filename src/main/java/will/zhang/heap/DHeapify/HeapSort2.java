package will.zhang.heap.DHeapify;

import will.zhang.util.SortTestHelper;

/**
 * Created by Will.Zhang on 2018/1/12 0012 17:31.
 * 堆排序2
 */
public class HeapSort2 {

    /**
     * 不允许有构造方法
     */
    private HeapSort2() {
    }

    /**
     * 对整个arr数组使用HeapSort2排序
     * HeapSort2是使用heapify的方式来创建堆
     * 创建堆的事件复杂度为O(n), 从堆中依次取出元素的时间复杂度为O(nlogn)
     * 排序整体时间复杂度为O(nlogn),但是由于使用heapify的方式创建堆
     * 所以速度更优
     * @param arr
     */
    public static void sort(Comparable[] arr){

        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateRandomArray(10, 0 ,10);
        HeapSort2.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
