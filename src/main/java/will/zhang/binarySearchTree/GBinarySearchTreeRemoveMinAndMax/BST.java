package will.zhang.binarySearchTree.GBinarySearchTreeRemoveMinAndMax;

import java.util.LinkedList;

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

    /**
     * 往二分搜索树插入节点
     * @param key
     * @param value
     */
    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }

    /**
     * 在二分搜索树中搜索键key所对应的值. 如果值不存在则返回Null
     * @param key
     * @return
     */
    public Value search(Key key){
        return search(root, key);
    }

    /**
     * 检查key是否存在于树中
     * @param key
     * @return
     */
    public boolean contain(Key key){
        return contain(root, key);
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        //使用linkList作为队列
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node node = q.remove();

            System.out.println(node.key);

            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    }

    /**
     * 获取二分搜索树的小键值
     * @return
     */
    public Key minimum(){
        return minimum(root).key;
    }

    /**
     * 获取二分搜索树的最大键值
     * @return
     */
    public Key maximum(){
        return maximum(root).key;
    }

    /**
     * 从二分搜索树中删除最小节点
     */
    public void removeMin(){
        if(root != null){
            root = removeMin(root);
        }
    }

    /**
     * 从二分搜索树删除最大节点
     */
    public void removeMax(){
        if(root != null){
            root = removeMax(root);
        }
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
     * 二分搜索树核心辅助函数
     * 查看以node为根的二分搜索树是否包含键值为key的节点
     * 使用递归算法
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, Key key){
        //处理递归到底的情况
        if(node == null){
            return false;
        }
        //找到的话直接返回true
        if(key.compareTo(node.key) == 0){
            return true;
        }else if(key.compareTo(node.key) > 0){
            return contain(node.right, key);
        }else {
            return contain(node.left, key);
        }
    }

    /**
     * 二分搜索树核心辅助函数
     * 查看以node为根的二分搜索树键为key的值
     * 如果不存在则返回null
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node, Key key){
        //处理递归到底的情况
        if(node == null){
            return null;
        }
        //找到的话直接返回
        if(key.compareTo(node.key) == 0){
            return node.value;
        }else if(key.compareTo(node.key) > 0){
            return search(node.right, key);
        }else{
            return search(node.left, key);
        }
    }

    /**
     * 前序遍历, 递归算法
     * @param node
     */
    private void preOrder(Node node){
        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历, 递归算法
     * @param node
     */
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 后续遍历, 递归算法
     * @param node
     */
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 返回以node为根的二分搜索树的最小键值的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 返回以node为跟的二分搜索树的最大键值的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return minimum(node.right);
    }

    /**
     * 删除以node为根的二分搜索树中最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            //二分搜索树的最小值只会有右节点,不会有左节点
            //并且右节点有可能不存在,为null,不过也没关系
            Node rightNode = node.right;
            node.right = null;
            count --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除以node为根的二分搜索树中最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            //二分搜索树的最大值只会有左节点,不会有右节点
            //并且左节点有可能不存在,为null,不过也没关系
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public static void main(String[] args) {
        int N = 10;

        Integer[] arr = new Integer[N];

        //创建一个数组, 包含[0...N)的所有元素
        for (int i = 0; i < N; i++) {
            arr[i] = new Integer(i);
        }

        // 打乱数组顺序, 预防退化成链表
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        //使用键为Integer, 值为String的二分搜索树
        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < N; i++) {
            bst.insert(arr[i], Integer.toString(arr[i]));
        }

        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(i);
            if(i < N){
                assert res.equals(Integer.toString(i));
            }else{
                assert res == null;
            }
        }


    }
}
