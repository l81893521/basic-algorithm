package will.zhang.advance.HInversionCount;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2017/11/20 0020 16:57.
 * 使用Merge Sort的思想, 计算出逆序对
 */
public class InversionCount {

    /**
     * 不允许产生实例
     */
    private InversionCount() {
    }

    public static long solve(Comparable[] arr){

        int n = arr.length;
        return solve(arr, 0, n-1);
    }

    private static long solve(Comparable[] arr, int l, int r){
        if(l >= r){
            return 0L;
        }

        int mid = l + (r - l) / 2;
        //求出arr[l...mid]范围的逆序数
        long res1 = solve(arr, l, mid);
        long res2 = solve(arr, mid+1, r);

        return res1 + res2 + merge(arr, l, mid, r);
    }

    private static long merge(Comparable[] arr, int l, int mid, int r){
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        //初始化逆序数对个数
        long res = 0L;
        //初始化,i指向左半部分的起始索引l; j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for (int k = l; k <= r ; k++) {
            if(i > mid){ //如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j++;
            }else if(j > r){ //如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l]) <= 0){ //左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            }else{  //左半部分所指元素 > 右半部分所指元素
                arr[k] = aux[j-l];
                j++;
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                res += (mid - i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 10;
        //生成一个随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " : " + solve(arr) );

        //生成一个接近于有序的数组
        int swap = 100;
        Integer[] arr1 = SortTestHelper.generateOrderedArray(N);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " : " + solve(arr1) );

        //生成一个范围很小的数组
        Integer[] arr2 = SortTestHelper.generateInversedArray(N);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " : " + solve(arr2) );


    }
}
