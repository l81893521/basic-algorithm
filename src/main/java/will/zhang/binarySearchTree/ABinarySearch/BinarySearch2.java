package will.zhang.binarySearchTree.ABinarySearch;

/**
 * Created by Will.Zhang on 2018/1/17 0017 17:36.
 * 二分查找法
 * 递归实现
 */
public class BinarySearch2 {

    /**
     * 不允许产生实例
     */
    private BinarySearch2() {
    }

    /**
     * 二分查找法
     * 以递归的方式对arr[l...r]查找目标target
     * @param arr 需要保证数组必须是有序的
     * @param l
     * @param r
     * @param target
     * @return
     */
    private static int search(Comparable[] arr, int l, int r, Comparable target){
        //在找不到的情况返回-1
        if(l > r) return -1;
        /*
        找出中间点, 但是请勿使用(l+r)/2这个方法, 因为这会引起溢出问题
         */
        int p = l + (r - l) / 2;

        //找到的情况直接返回目标的下标p
        if(target.compareTo(arr[p]) == 0){
            return p;
        }
        //递归查找
        if(target.compareTo(arr[p]) > 0){
            return search(arr, p + 1, r, target);
        }else{
            return search(arr, 0, p -1, target);
        }
    }

    public static int find(Comparable[] arr, Comparable target){
        return search(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {
        int N = 1000000;
        //一个有序的数组
        Integer arr[] = new Integer[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(BinarySearch2.find(arr, 10));
    }
}
