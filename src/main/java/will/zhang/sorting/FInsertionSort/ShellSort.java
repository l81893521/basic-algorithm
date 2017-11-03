package will.zhang.sorting.FInsertionSort;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/2 0002 15:07.
 */
public class ShellSort {

    /**
     * 不允许产生实例
     */
    private ShellSort() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;

        int h = 1;

        while (h < n/3){
            h = 3 * h + 1;
        }

        while(h >=1){

            for (int i = h; i < n; i++) {
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j-h]) < 0 ; j-=h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }

//            for (int i = h; i < n; i++) {
//                for (int j = i; j >= h && arr[i].compareTo(arr[j-h]) < 0 ; j-=h) {
//                    SortTestHelper.swap(arr, i, (j-h));
//                }
//            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
//        int N = 11;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr = {10, 6, 8, 2, 7, 4, 11, 5, 10, 2, 1};
        SortTestHelper.testSortPerformance("will.zhang.sorting.FInsertionSort.ShellSort", arr);
        System.out.println(Arrays.toString(arr));
    }
}
