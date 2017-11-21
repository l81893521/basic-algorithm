package will.zhang.advance.CMergeSortBottomUp;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/14 0014 18:02.
 * 归并排序(自低向上)
 * 复杂度:O(nlogn)
 * 缺点:使用了额外空间
 */
public class MergeSortBU {

    /**
     * 不允许产生实例
     */
    private MergeSortBU() {

    }

    public static void sort(Comparable[] arr){

        int n = arr.length;

        /*
        优化部分
        对小部分的数组, 使用插入排序
        这也是一个可选的优化项
        数组越接近有序, 效果越明显
        数组越接近于无序, 效果越差
         */
        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i+15, n-1));
        }



        for(int sz = 16; sz < n; sz += sz){
            // 在merge的时候
            // i+sz-1有可能会比n还大(已经超出了数组的大小,触发越界问题)
            // 所以在循环这里要做一个限制 i + sz < n 或者 i < n -sz
            for (int i = 0; i + sz < n; i += sz + sz) {
                /*
                优化部分
                加入if判断进行优化
                可以试想一下,MergeSort的左半部分和右半部分都是有序的
                那么左半部分的最大值, 已经小于右半部分的最小值, 那么表示目前这一段已经是有序
                无需要再进行归并
                注意:
                这是一个可选的优化项
                因为当数组越接近有序,优化效果会越大
                反之数组完全随机,那么优化效果未必会很好,因为if这个判断本身也会消耗性能
                 */
                if(arr[i+sz-1].compareTo(arr[i+sz]) > 0){
                    //对 arr[i...i+sz-1] 和 arr[i+sz...i+sz+sz-1]进行归并
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n-1));
                }
            }
        }

        /*
        这是优化前的写法
        int n = arr.length;
        for(int sz = 1; sz < n; sz += sz){
            for (int i = 0; i + sz < n; i += sz + sz) {
                //对 arr[i...i+sz-1] 和 arr[i+sz...i+sz+sz-1]进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n-1));
            }
        }
        */
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
        int N = 32;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSortPerformance("will.zhang.advance.CMergeSortBottomUp.MergeSortBU", arr);
        System.out.println(Arrays.toString(arr));
    }
}
