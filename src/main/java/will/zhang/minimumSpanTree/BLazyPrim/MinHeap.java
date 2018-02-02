package will.zhang.minimumSpanTree.BLazyPrim;

/**
 * Created by Will.Zhang on 2018/2/1 0001 18:24.
 * 最小堆
 */
public class MinHeap<Item extends Comparable>{

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MinHeap(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        this.count = 0;
        this.data = (Item[]) new Comparable[capacity + 1];
    }

    /**
     * 返回堆中元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 查询堆中最小的元素
     * @return
     */
    public Item getMin(){
        assert count > 0;
        return data[1];
    }

    /**
     * 取出堆中最小元素
     * @return
     */
    public Item extractMin(){
        assert count > 0;

        Item reuslt = data[1];
        swap(1, count);
        count--;
        shiftDown(1);

        return reuslt;
    }

    /**
     * 向最小堆插入一个元素
     * @param item
     */
    public void insert(Item item){
        assert count + 1 <= capacity;

        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    /**
     * 最小堆核心辅助函数
     * @param k
     */
    private void shiftUp(int k){
        while (k > 1 && data[k].compareTo(data[k / 2]) < 0){
            swap(k, k/2);
            k/=2;
        }
    }

    /**
     * 最小堆核心辅助函数
     * @param k
     */
    private void shiftDown(int k){
        while (2*k <= count){
            int j = 2*k;
            if(j + 1 <= count && data[j+1].compareTo(data[j]) < 0){
                j++;
            }

            if(data[k].compareTo(data[j]) <= 0){
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    /**
     * 交换堆中索引i和j的位置
     * @param i
     * @param j
     */
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    // 测试 MinHeap
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
