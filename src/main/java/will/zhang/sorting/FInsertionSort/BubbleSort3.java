package will.zhang.sorting.FInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/2 0002 14:42.
 */
public class BubbleSort3 {

    /**
     * 不允许产生实例
     */
    private BubbleSort3() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        int newN;

        do{
            newN = 0;
            for (int i = 1; i < n; i++) {
                if(arr[i-1].compareTo(arr[i]) > 0){
                    SortTestHelper.swap(arr, i-1, i);
                    /*
                    第一次循环, newN会不断被赋值
                    最后会记录下最后交换的下标(也表示数组后面的元素都已经是有序)
                     */
                    newN = i;
                }
            }
            /*
            更改n的大小
            相当于缩小了循环的长度
             */
            n = newN;
        }while(newN > 0);
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.BubbleSort3", arr);
        System.out.println(Arrays.toString(arr));
    }
}
