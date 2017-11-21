package will.zhang.advance.ISelection;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/21 0021 14:57.
 * 使用QuickSort的思想
 * 找出arr中第k小的元素
 */
public class Selection {

    /**
     * 不允许产生实例
     */
    private Selection(){};

    /**
     * partition
     * 和QuickSort的partition一样
     * 返回p
     * 使得arr[l...p-1] < arr[p]; [p+1...r] > arr[p]
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable[] arr, int l, int r){
        /*
         * 将第0个元素,和数组里面随机一个元素交换
         * 从而避免数组接近于有序, 导致算法的树高度接近于n, 出现退化到n方的问题
         */
        SortTestHelper.swap(arr, l, (int)(Math.random() * (r - l + 1) + l));

        Comparable v = arr[l];

        //arr[l+1...j] < v; arr[j+1...i] > v
        int j = l;
        for (int i = l; i <= r; i++) {
            if(arr[i].compareTo(v) < 0){
                j++;
                SortTestHelper.swap(arr, j, i);
            }
        }

        SortTestHelper.swap(arr, l , j);

        return j;
    }

    /**
     * 递归找出第k小的元素
     * @param arr
     * @param l
     * @param r
     * @param k
     * @return
     */
    private static Comparable solve(Comparable[] arr, int l, int r, int k){
        if(l == r){
            return arr[l];
        }
        //经过partition之后, 使得arr[l...p-1] < arr[p]; [p+1...r] > arr[p]
        int p = partition(arr, l, r);

        if(k == p){//已经找出第k小的元素了
            return arr[p];
        }else if (k < p){   // k < p 从左部分的数组继续寻找
            return solve(arr, l, p-1, k);
        }else { //k > p 从右半部分的数组继续寻找
            return solve(arr, p+1, r, k);
        }

    }

    /**
     * 寻找arr中第k小的元素
     * @param arr
     * @param n
     * @param k
     * @return
     */
    public static Comparable solve(Comparable[] arr, int n, int k){
        assert k >= 0 && k < n;
        return solve(arr, 0, n-1, k);
    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        //寻找数组中第5小的元素
        int k = 5;
        System.out.println(solve(arr, N, k));

    }
}
