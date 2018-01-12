package will.zhang.heap.DHeapify;

import will.zhang.util.SortTestHelper;

/**
 * Created by Will.Zhang on 2018/1/12 0012 17:06.
 * 堆排序
 */
public class HeapSort {

    /**
     * 不允许产生实例
     */
    private HeapSort() {
    }

    /**
     * 对整个数组使用heapSort1排序
     * 无论是创建堆的过程, 还是从堆依次取出元素, 时间复杂度均为O(nlogn)
     * 整个堆排序的时间复杂度为O(nlogn)
     * @param arr
     */
    public static void sort(Comparable[] arr){
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr.length);
        //初始化heap(初始化完成已经有序)
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }

        //反向取出,完成从小到大的排序
        for (int i = arr.length - 1; i >= 0 ; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateRandomArray(10, 0 ,10);
        HeapSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
