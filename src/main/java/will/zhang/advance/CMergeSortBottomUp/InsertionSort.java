package will.zhang.advance.CMergeSortBottomUp;

/**
 * Created by Will.Zhang on 2017/11/1 0001 11:15.
 */
public class InsertionSort {

    /**
     * 不允许产生实例
     */
    private InsertionSort() {
    }

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

    /**
     * 对[l...r]进行InsertionSort
     * @param arr
     * @param l
     * @param r
     */
    public static void sort(Comparable[] arr, int l, int r){
        for (int i = l+1; i <= r; i++) {
            Comparable c = arr[i];
            int j;
            for (j = i; j > l && c.compareTo(arr[j-1]) < 0 ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = c;
        }
    }
}
