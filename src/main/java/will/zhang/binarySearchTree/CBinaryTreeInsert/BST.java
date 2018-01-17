package will.zhang.binarySearchTree.CBinaryTreeInsert;

/**
 * Created by Will.Zhang on 2018/1/17 0017 18:26.
 * 二分搜索树
 * 由于key要进行比较,所以必须实现Comparable
 */
public class BST<Key extends Comparable, Value>{

    /**
     * 树中的节点为私有类, 外界不需要了解二分搜索树的具体实现
     */
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 树根
     */
    private Node root;
    /**
     * 树中节点的个数
     */
    private int count;

    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }

    /**
     * 二分搜索树核心辅助函数
     * 向以node为根的二分搜索树, 插入node(key, value), 使用递归算法
     * 返回插入新节点后的二分搜索树根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, Key key, Value value){
        //递归到底的情况, 返回新创建的node
        if(node == null){
            count ++;
            return new Node(key ,value);
        }

        if(key.compareTo(node.key) == 0){
            //在key相等的情况下, 则修改值
            node.value = value;
        }else if(key.compareTo(node.key) > 0){
            node.right = insert(node.right, key, value);
        }else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    /**
     * 返回树中节点的个数
     * @return
     */
    public int size(){
        return this.count;
    }

    /**
     * 树是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.count == 0;
    }

    public static void main(String[] args) {

    }
}
