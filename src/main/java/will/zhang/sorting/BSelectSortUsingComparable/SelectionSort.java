package will.zhang.sorting.BSelectSortUsingComparable;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 不允许产生实例
     */
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[i]) < 0){
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
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
        Student[] students = {new Student("张庆安", 30), new Student("陈光辉", 40), new Student("张嘉伟", 99)};
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
