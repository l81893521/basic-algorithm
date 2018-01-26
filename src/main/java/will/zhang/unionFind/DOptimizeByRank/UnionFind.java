package will.zhang.unionFind.DOptimizeByRank;

/**
 * Created by Will.Zhang on 2018/1/24 0024 16:43.
 * 第一版的Union-Find
 */
public class UnionFind {

    /**
     * 第一版的Union-Find本质就是一个数组
     */
    private int[] id;
    /**
     * 数据的个数
     */
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找过程, 查找元素p锁对应的集合编号
     * O(1)复杂度
     * @param p
     * @return
     */
    public int find(int p){
        assert p >= 0 && p < count;
        return id[p];
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     * O(1)复杂度
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * O(n)复杂度
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return;
        }
        //合并过程需要遍历以便所有的元素, 将两个元素的所属集合编号合并
        for (int i = 0; i < count; i++) {
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
