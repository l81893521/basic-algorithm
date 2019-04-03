package will.zhang.basic.FInsertionSort;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/1 0001 11:15.
 */
public class InsertionSort {

    /**
     * 不允许产生实例
     */
    private InsertionSort() {}

    /**
     * 经过优化的InsertionSort
     * @param arr
     */
    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            //把需要排序的元素arr[i]先保存起来
            Comparable c = arr[i];
            //保存元素c应该插入的位置
            int j;
            for (j = i; j > 0 && c.compareTo(arr[j-1]) < 0; j--) {
                //经过优化后,内层循环每次只需要做1次赋值操作
                arr[j] = arr[j-1];
            }
            arr[j] = c;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        System.out.println("对随机数组进行测试, size = " + N + " , 数字大小范围 [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSortPerformance("will.zhang.basic.EInsertionSort.SelectionSort", arr1);
        SortTestHelper.testSortPerformance("will.zhang.basic.EInsertionSort.InsertionSort", arr2);
        SortTestHelper.testSortPerformance("will.zhang.basic.FInsertionSort.InsertionSort", arr3);

        //第二步 测试高有序性的数据
        int swapTime = 10;
        Integer[] arr4 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        System.out.println("对接近有序的数组进行测试, size = " + N );
        SortTestHelper.testSortPerformance("will.zhang.basic.FInsertionSort.InsertionSort", arr4);
    }
}
