package will.zhang.minimumSpanTree.COptimizedPrim;

/**
 * Created by Will.Zhang on 2018/2/2 0002 14:56.
 */
public class IndexMinHeap<Item extends Comparable> {

    /**
     * 最小索引堆中的数据
     */
    protected Item[] data;
    /**
     * 最小索引堆中的索引, indexes[x] = i 表示索引i在x的位置
     */
    protected int[] indexes;
    /**
     * 最小索引堆中的反向索引, reverse[i] =x 表示索引i在x的位置
     */
    protected int[] reverse;
    /**
     * 最小索引堆元素数量
     */
    protected int count;
    /**
     * 最小索引堆容量
     */
    protected int capacity;

    /**
     * 最小索引堆构造函数
     * @param capacity
     */
    public IndexMinHeap(int capacity){
        data = (Item[]) new Comparable[capacity + 1];

        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        //反向索引初始化都为0
        for (int i = 0; i < capacity; i++) {
            reverse[i] = 0;
        }

        count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回最小索引堆元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回最小索引堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 向最小索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
     * 传入的i对用户而言, 是从0索引的
     * @param i
     * @param item
     */
    public void insert(int i, Item item){
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        //在插入一个新元素之前, 保证索引i的位置是没有元素的
        assert !contain(i);

        i+=1;
        data[i] = item;
        reverse[i] = count + 1;
        indexes[count + 1] = i;

        count++;

        shiftUp(count);
    }

    /**
     * 将最小索引堆中索引为i的元素修改为newItem
     * @param i
     * @param newItem
     */
    public void change(int i, Item newItem){
        assert contain(i);

        i += 1;
        data[i] = newItem;

        shiftUp( reverse[i] );
        shiftDown( reverse[i] );
    }

    /**
     * 从最小索引堆中取出堆顶元素
     * @return
     */
    public Item extractMin(){
        assert count > 0;

        Item result = data[indexes[1]];

        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return result;
    }

    /**
     * 从最小索引堆中取出堆顶元素的索引
     * @return
     */
    public int extractMinIndex(){
        assert count > 0;
        int result = indexes[1] - 1;
        swapIndexes(1, count);
        shiftDown(1);
        reverse[indexes[count]] = 0;
        count--;

        return result;
    }

    /**
     * 获取最小索引堆中的堆顶元素
     * @return
     */
    public Item getMin(){
        assert count > 0;
        return data[indexes[1]];
    }

    /**
     * 获取最小索引堆中的堆顶元素的索引
     * @return
     */
    public int getMinIndex(){
        assert count > 0;
        return indexes[1] - 1;
    }

    /**
     * 索引堆中, 数据之剑比较根据data的大小进行比较, 但实际操作的是索引
     * @param k
     */
    private void shiftUp(int k){
        while (k > 1 && data[indexes[k]].compareTo(data[indexes[k/2]]) < 0){
            swapIndexes(k, k/2);
            k /= 2;
        }
    }

    /**
     * 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
     * @param k
     */
    private void shiftDown(int k){
        while ( 2*k <= count){
            int j = 2 * k;
            if(j + 1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) < 0){
                j++;
            }

            if(data[indexes[k]].compareTo(data[indexes[j]]) <= 0){
                break;
            }

            swapIndexes(k, j);
            k = j;
        }
    }

    /**
     * 交换索引堆中的索引i和j
     * 并且维护反向索引reverse
     * @param i
     * @param j
     */
    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
        //indexes[i]和indexes[j]已经替换过了, 这里直接赋值就可以了
        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    /**
     * 查看索引i所在的位置是否存在元素
     *
     * @param i
     * @return
     */
    private boolean contain(int i){
        assert  i + 1 >= 1 && i + 1 <= capacity;

        return reverse[i+1] != 0;
    }

    // 测试 IndexMinHeap
    public static void main(String[] args) {

        int N = 10;
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMinHeap.insert( i , (int)(Math.random()*N) );

        for (int i = 0; i < N; i++) {
            System.out.println(indexMinHeap.extractMin());
        }
    }
}
