package will.zhang.sorting.FInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/1 0001 18:52.
 */
public class BubbleSort2 {

    /**
     * 不允许产生实例
     */
    private BubbleSort2() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        /*
        用于标识元素是否进行过交换,如果没有进行交换
        则代表数组已经是有序,无需继续排序
        在接近于有序的数组中,性能提升非常大
         */
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if(arr[i-1].compareTo(arr[i]) > 0){
                    SortTestHelper.swap(arr, i-1, i);
                    /*
                    标识是否进行过交换
                    好处是,如果整个数组是准有序的(只有少量值需要排序)
                    那么整个排序就可以提早退出(因为内层循环没有发现需要交换的值,swapped=false)
                     */
                    swapped = true;
                }
            }
            //每经过一轮循环,最后的元素可以忽略,属于优化项
            n--;
        }while(swapped);
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.BubbleSort2", arr);
//        System.out.println(Arrays.toString(arr));
    }
}
