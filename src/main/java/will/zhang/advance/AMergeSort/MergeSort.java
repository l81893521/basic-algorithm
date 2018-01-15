package will.zhang.advance.AMergeSort;

import will.zhang.util.SortTestHelper;

/**
 * Created by Will.Zhang on 2017/11/8 0008 17:34.
 * 归并排序
 * 复杂度:O(nlogn)
 * 缺点:使用了额外空间
 */
public class MergeSort {

    /**
     * 不允许产生实例
     */
    private MergeSort() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;

        mergeSort(arr, 0, n-1);
    }

    /**
     * 对数字arr[l...r]的范围进行排序
     * @param arr 数组
     * @param l 最左边的元素(left)
     * @param r 最右边的元素(right)
     */
    private static void mergeSort(Comparable[] arr, int l, int r){

        //不断进行二分,直到每个数组只剩下一个元素的时候则退出(只剩下1个元素的数组,就已经是有序)
        if(l >= r) return;

        //计算出中点位置(注意如果l+r有可能发生溢出的错误)
        int mid = (l+r)/2;

        //把数组分开一半,分别对两边进行排序
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]这两个部分,进行归并
     * @param arr
     * @param l 最左边的元素(left)
     * @param mid 数组的中间值
     * @param r 最右边的元素(right)
     */
    private static void merge(Comparable[] arr, int l, int mid, int r){
        Comparable[] aux = new Comparable[r-l+1];
        for (int i = l; i <= r ; i++) {
            aux[i-l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r ; k++) {
            // 比较临时数组
            if(i > mid){ // 左半部分的元素已经全部处理完毕
                arr[k] = aux[j-l];
                j++;
            }else if(j > r){ //右半部分的元素已经全部处理完毕
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l]) < 0){ // 左半部分所指的元素 < 右半部分所指的元素
                arr[k] = aux[i-l];
                i++;
            }else{  // 左半部分所指的元素 > 右半部分所指的元素
                arr[k] = aux[j-l];
                j++;
            }
        }
    }



    public static void main(String[] args) {
        int N = 8;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        // 可以在1秒内轻松处理100万以上的数据
        // 但是不要使用O(n^2)的算法来处理那么大的数据,如SelectionSort, InsertionSort或BubbleSort
        // 否则会等死人
        SortTestHelper.testSortPerformance("will.zhang.advance.AMergeSort.MergeSort", arr);
//        System.out.println(Arrays.toString(arr));
    }
}
