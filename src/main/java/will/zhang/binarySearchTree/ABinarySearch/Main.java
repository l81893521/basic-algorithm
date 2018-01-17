package will.zhang.binarySearchTree.ABinarySearch;

/**
 * Created by Will.Zhang on 2018/1/17 0017 18:10.
 */
public class Main {

    public static void main(String[] args) {
        int N = 1000000;
        //一个有序的数组
        Integer arr[] = new Integer[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 测试非递归二分查找法
        long startTime = System.currentTimeMillis();

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search (Without Recursion): " + (endTime - startTime) + "ms");

        // 测试递归的二分查找法
        startTime = System.currentTimeMillis();

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = BinarySearch2.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search (With Recursion): " + (endTime - startTime) + "ms");
    }
}
