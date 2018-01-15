package will.zhang.heap.EHeapSort;

import will.zhang.util.SortTestHelper;

/**
 * Created by Will.Zhang on 2018/1/15 0015 15:07.
 * 原地堆排序
 */
public class HeapSort3 {

    private HeapSort3() {
    }

    /**
     * shiftDown操作, 堆的核心辅助函数
     * @param arr
     * @param n
     * @param k
     */
    private static void shiftDown(Comparable[] arr, int n, int k){
        while(k * 2 + 2 <= n){
            //j是需要交换的位置,先假设左节点较大(leftChild=k*2, 如果下标从0开始则是k * 2 + 1)
            int j = k * 2 + 1;
            if(j + 1 < n && arr[j].compareTo(arr[j+1]) < 0){
                //如果右节点较大，则j=右节点(rightChild=k*2+1, 如果下标从0开始则是k * 2 + 2)
                j++;
            }
            //上面的判断已经得出2个子节点中较大的那一个,如果还是比父节点小，则无需交换
            if(arr[k].compareTo(arr[j]) > 0){
                break;
            }
            SortTestHelper.swap(arr, k, j);
            //改变k的位置，继续往下对比
            k = j;
        }
    }

    /**
     * 借鉴优化快排的思想
     * 经过优化的shiftDown, 不再频繁swap数组
     * @param arr
     * @param n
     * @param k
     */
    private static void shiftDown2(Comparable[] arr, int n, int k){
        Comparable c = arr[k];

        while(k * 2 + 2 <= n){

            int j = 2 * k + 1;
            if(j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0){
                j++;
            }

            if(arr[k].compareTo(arr[j]) > 0){
                break;
            }

            arr[k] = arr[j];

            k = j;
        }
        arr[k] = c;
    }

    /**
     * 原地堆排序, 不需要创建额外的空间, 直接在传入的数组中操作
     * @param arr
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;

        /**
         * heapify操作, 但是要注意下标是从0开始的
         * 计算最后一个非叶子节点的时候要注意减1
         */
        for (int i = (n-1-1) / 2; i >= 0 ; i--) {
            shiftDown2(arr, n , i);
        }


        for (int i = 0; i < n; i++) {
            SortTestHelper.swap(arr, 0 , (n - 1) - i);
            shiftDown(arr, n - i - 1 , 0);
        }


    }

    public static void main(String[] args) {
        Comparable[] arr = SortTestHelper.generateRandomArray(11, 0 ,9);
        HeapSort3.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
