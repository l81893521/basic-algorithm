package will.zhang.basic.BSelectSortUsingComparable;

import will.zhang.util.SortTestHelper;

import java.util.Arrays;

/**
 * 对选择排序所做的一个更改
 * 凡是实现了Comparable接口的类
 * 都可以排序
 */
public class SelectionSort {

    /**
     * 不允许产生实例
     */
    private SelectionSort() {}

    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[i]) < 0){
                    SortTestHelper.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        //测试int
        Integer[] arr = {5, 9, 8, 7, 10, 6, 3, 0, 2, 1, 4};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        //测试double
        Double[] d = {5.5, 9.9, 8.8, 7.7, 10.1, 6.6, 3.3, 0d, 2.2, 1.1, 4.4};
        SelectionSort.sort(d);
        System.out.println(Arrays.toString(d));

        //测试character
        Character[] c = {'e','d','a','c','g','f','k','i'};
        SelectionSort.sort(c);
        System.out.println(Arrays.toString(c));

        //测试String
        String[] s = {"e","d","a","c","g","f","k","i"};
        SelectionSort.sort(s);
        System.out.println(Arrays.toString(s));

        //测试自定义对象
        Student[] students = {new Student("Tom", 30), new Student("Cat", 40), new Student("Dog", 99)};
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
