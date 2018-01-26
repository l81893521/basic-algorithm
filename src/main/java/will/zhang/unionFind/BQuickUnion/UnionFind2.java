package will.zhang.unionFind.BQuickUnion;

/**
 * Created by Will.Zhang on 2018/1/24 0024 17:28.
 * 第二个版本的Union-Find
 */
public class UnionFind2 {

    /**
     * 使用一个数组构建一颗指向父节点的树
     */
    private int[] parrent;
    /**
     * 数据个数
     */
    private int count;

    public UnionFind2(int n){
        count = n;
        parrent = new int[n];
        for (int i = 0; i < n; i++) {
            parrent[i] = i;
        }
    }

    /**
     * 查找过程, 查找元素p所对应的集合编号
     * O(h)复杂度, h为树的高度
     * @param p
     * @return
     */
    public int find(int p){
        assert p >= 0 && p < count;
        //不断去查询自己的父节点, 直到到达根节点
        //根节点的特点: p = parrent[p]
        while (p != parrent[p]){
            p = parrent[p];
        }
        return p;
    }

    /**
     * 查看元素p和元素q是否所属同一个集合
     * O(h)复杂度, h为树的高度
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * O(h)复杂度, h为树的高度
     * @param p
     * @param q
     */
    public void union(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        parrent[pRoot] = qRoot;
    }
}
