package will.zhang.sorting.FInsertionSort;

import java.lang.reflect.Method;

/**
 * Created by Will.Zhang on 2017/10/31 0031 16:52.
 */
public class SortTestHelper {

    /**
     * 不允许产生实例
     */
    private SortTestHelper(){};

    /**
     * 按照指定范围,生成指定大小数组
     * @param size 数组大小
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int size, int rangeL, int rangeR){

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[size];

        for (int i = 0; i < arr.length; i++) {
            int number = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
            arr[i] = number;
        }
        return arr;
    }

    /**
     * 生成接近于有序的的数组
     * @param size 数组大小
     * @param swapTime 随机将数组内的元素互相交换的次数
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int size, int swapTime){
        Integer[] arr = new Integer[size];
        //生成一个有序的数组
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        //随机将数组内的元素互相交换
        for (int i = 0; i < swapTime; i++) {
            int randomI = (int) (Math.random() * 10);
            int randomJ = (int) (Math.random() * 10);
            swap(arr,randomI, randomJ);
        }
        return arr;
    }

    /**
     * 判断数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i].compareTo(arr[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 交换数组元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 测试数组运行所需要的时间
     * @param arr
     */
    public static void testSortPerformance(String sortClassName, Comparable[] arr){
        try {
            //根据sortClassName获得Class对象
            Class sortClass = Class.forName(sortClassName);
            //根据Class对象获取sort方法
            Method method = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            //排序参数
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();

            method.invoke(null, params);

            long endTime = System.currentTimeMillis();
            //检查排序是否已经完成,不计入排序时间
            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
