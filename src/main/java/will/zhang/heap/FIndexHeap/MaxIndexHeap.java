package will.zhang.heap.FIndexHeap;

import will.zhang.util.SortTestHelper;

/**
 * 这只是一个最大堆
 * @param <T>
 */
public class MaxIndexHeap<T extends Comparable> {

    /**
     * 使用数组来实现一个最大堆
     */
    protected T[] data;
    /**
     * 用于维护数据的索引
     */
    private Integer[] indexes;
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
    public MaxIndexHeap(int capacity) {
        //下标0的位置是弃用的,所以capacity+1
        data = (T[]) new Comparable[capacity + 1];
        indexes = new Integer[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 使用heapify的方式创建堆
     * 时间复杂度为O(n)
     * @param arr
     */
    public MaxIndexHeap(T[] arr){
        data = (T[]) new Comparable[arr.length + 1];
        indexes = new Integer[arr.length + 1];
        this.capacity = arr.length;
        for (int i = 0; i < arr.length; i++) {
            data[i+1] = arr[i];
            indexes[i+1] = i+1;
            count++;
        }

        for (int i = arr.length / 2; i >= 1; i--) {
            shiftDown(i);
        }
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
    public void insert(int i, T t){
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        //下标0位置是启用的，所以+1
        data[i] = t;
        indexes[count + 1] = i;
        count++;
        //把元素调整到合适的位置（符合最大堆的要求）
        shiftUp(count);
    }

    /**
     * 取出堆中的最大值（树顶）
     * @return
     */
    public T extractMax(){
        assert count > 0;

        T result = data[indexes[1]];
        SortTestHelper.swap(indexes, 1, count);
        count--;
        shiftDown(1);
        return result;
    }

    /**
     * 查看堆顶元素
     * @return
     */
    public T getMax(){
        assert count > 0;
        return data[indexes[1]];
    }

    /**
     * 查看堆顶索引
     * 对于用户来说, 索引是从0开始, 所以要-1
     * @return
     */
    public int getMaxIndex(){
        assert count > 0;
        return indexes[1] - 1 ;
    }

    /**
     * 查看最大索引堆中索引为i的元素
     * @param i
     * @return
     */
    public T getItem(int i){
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i+1];
    }

    /**
     * 将最大索引堆中索引为i的元素修改为t
     * @param i
     * @param t
     */
    public void change(int i, T t){
        assert i + 1 >= 1 && i + 1 <= capacity;
        //修改元素
        data[i] = t;
        /*
        重新维护索引
        找到indexes[j] == i, j表示data[i]在堆中的位置
         */
        for (int j = 1; j <= count ; j++) {
            if(indexes[j].compareTo(i) == 0){
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    /**
     * 最大堆核心辅助函数
     * 把元素调整到合适的位置
     * @param k
     */
    private void shiftUp(int k){
        //和父节点比较，如果小于父节点，则交换
        while (k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) < 0){
            SortTestHelper.swap(indexes, k/2, k);
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
            if(j + 1 <=count && data[indexes[j]].compareTo(data[indexes[j+1]]) < 0){
                //如果右节点较大，则j=右节点(rightChild=k*2+1)
                j++;
            }
            //上面的判断已经得出2个子节点中较大的那一个,如果还是比父节点小，则无需交换
            if(data[indexes[k]].compareTo(data[indexes[j]]) > 0){
                break;
            }
            SortTestHelper.swap(indexes, k, j);
            //改变k的位置，继续往下对比
            k = j;
        }
    }


    public static void main(String[] args) {
        int capacity = 10;

        int M = 100;
        MaxIndexHeap<Integer> maxIndexHeap = new MaxIndexHeap<Integer>(capacity);

        for (int i = 0; i < capacity; i++) {
            maxIndexHeap.insert(i, new Integer((int)(Math.random() * M)));
        }

        while (!maxIndexHeap.isEmpty()){
            System.out.println(maxIndexHeap.extractMax());
        }
    }
}

