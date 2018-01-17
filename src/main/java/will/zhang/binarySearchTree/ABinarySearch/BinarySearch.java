package will.zhang.binarySearchTree.ABinarySearch;

/**
 * Created by Will.Zhang on 2018/1/17 0017 17:12.
 * 二分查找法
 */
public class BinarySearch {

    /**
     * 不允许产生实例
     */
    private BinarySearch() {
    }

    /**
     * 二分查找法
     * @param arr 需要保证数组必须是有序的
     * @param target
     * @return 返回结果的下标值
     */
    public static int find(Comparable[] arr, Comparable target){

        //在arr[l...r]中查找target
        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            /*
            找出中间点, 但是请勿使用(l+r)/2这个方法, 因为这会引起溢出问题
             */
            int p = l + (r - l) / 2;
            //如果找到结果直接返回
            if(target.compareTo(arr[p]) == 0){
                return p;
            }
            if(target.compareTo(arr[p]) > 0){
                l = p + 1;
            }else{
                r = p - 1;
            }
        }
        //如果找不到则返回-1
        return -1;
    }

    public static void main(String[] args) {
        int N = 1000000;
        //一个有序的数组
        Integer arr[] = new Integer[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(BinarySearch.find(arr, 10));

    }
}
