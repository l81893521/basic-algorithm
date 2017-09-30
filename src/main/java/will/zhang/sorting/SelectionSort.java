package will.zhang.sorting;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/9/30 0030 18:08.
 * 选择排序法
 */
public class SelectionSort {

    //不允许产生实例
    private SelectionSort() {
    }

    /**
     * 排序(从小到大)
     * @param arr
     */
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                //遇到更小的则交换
                if(arr[j] < min){
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
