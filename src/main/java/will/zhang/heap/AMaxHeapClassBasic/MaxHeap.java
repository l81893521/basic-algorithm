package will.zhang.heap.AMaxHeapClassBasic;

/**
 * 这只是一个最大堆的骨架，并没有任何功能
 * @param <T>
 */
public class MaxHeap<T> {

    /**
     * 使用数组来实现一个最大堆
     */
    private T[] data;
    /**
     * 堆里面元素的个数
     */
    private int count;

    public MaxHeap(int capacity) {
        data = (T[]) new Object[capacity];
        this.count = 0;
    }

    /**
     * 返回堆中元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(10);
        System.out.println(maxHeap.size());
    }
}

