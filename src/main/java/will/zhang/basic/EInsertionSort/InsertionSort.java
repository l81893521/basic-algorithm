package will.zhang.basic.EInsertionSort;

import will.zhang.util.SortTestHelper;

/**
 * Created by Will.Zhang on 2017/10/31 0031 17:27.
 * 插入排序
 */
public class InsertionSort {

    /**
     * 不允许产生实例
     */
    private InsertionSort(){}

    /**
     * 插入排序
     * 未经过优化
     * @param arr
     */
    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            //非优雅写法
//            for (int j = i; j > 0; j--) {
//                if(arr[j].compareTo(arr[j-1]) < 0){
//                    SortTestHelper.swap(arr, j, j-1);
//                }else{
//                    break;
//                }
//            }
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                SortTestHelper.swap(arr, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        //排序测试
        Integer[] arr = SortTestHelper.generateRandomArray(20000,0,20000);
        SortTestHelper.testSortPerformance("will.zhang.basic.EInsertionSort.InsertionSort", arr);
    }
}

