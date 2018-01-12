package will.zhang.heap.CShiftDown;

import will.zhang.util.SortTestHelper;

/**
 * 这只是一个最大堆
 * @param <T>
 */
public class MaxHeap<T extends Comparable> {

    /**
     * 使用数组来实现一个最大堆
     */
    protected T[] data;
    /**
     * 堆里面元素的个数
     */
    protected int count;
    /**
     * 堆的容量
     */
    protected int capacity;

    /**
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        //下标0的位置是弃用的,所以capacity+1
        data = (T[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
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

    /**
     * 往最大堆插入一个元素
     * @param t
     */
    public void insert(T t){
        assert count + 1 <= capacity;
        //下标0位置是启用的，所以+1
        data[count + 1] = t;
        count++;
        //把元素调整到合适的位置（符合最大堆的要求）
        shiftUp(count);
    }

    /**
     * 取出堆中的最大值（树顶）
     * @return
     */
    public T extractMax(){
        T result = data[1];
        SortTestHelper.swap(data, 1, count);
        count--;
        shiftDown(1);
        return result;
    }

    /**
     * 最大堆核心辅助函数
     * 把元素调整到合适的位置
     * @param k
     */
    private void shiftUp(int k){
        //和父节点比较，如果小于父节点，则交换
        while (k > 1 && data[k/2].compareTo(data[k]) < 0){
            SortTestHelper.swap(data, k/2, k);
            k /= 2;
        }
    }

    /**
     * 最大堆核心辅助函数
     * 把元素调整到合适的位置
     * @param k
     */
    private void shiftDown(int k){

        while(k * 2 <= count){
            //j是需要交换的位置,先假设左节点较大(leftChild=k*2)
            int j = k * 2;
            if(j + 1 <=count && data[j].compareTo(data[j+1]) < 0){
                //如果右节点较大，则j=右节点(rightChild=k*2+1)
                j++;
            }
            //上面的判断已经得出2个子节点中较大的那一个,如果还是比父节点小，则无需交换
            if(data[k].compareTo(data[j]) > 0){
                break;
            }
            SortTestHelper.swap(data, k, j);
            //改变k的位置，继续往下对比
            k = j;
        }


    }


    public static void main(String[] args) {
        int capacity = 10;

        int M = 100;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(capacity);

        for (int i = 0; i < capacity; i++) {
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.extractMax());
        }
    }
}

