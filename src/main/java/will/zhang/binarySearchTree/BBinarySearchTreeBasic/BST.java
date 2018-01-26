package will.zhang.binarySearchTree.BBinarySearchTreeBasic;

/**
 * Created by Will.Zhang on 2018/1/17 0017 18:26.
 * 二分搜索树
 * 由于key要进行比较,所以必须实现Comparable
 */
public class BST <Key extends Comparable, Value>{

    /**
     * 树中的节点为私有类, 外界不需要了解二分搜索树的具体实现
     */
    private class Note {
        private Key key;
        private Value value;
        private Note left;
        private Note right;

        public Note(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 树根
     */
    private Note root;
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

    public static void main(String[] args) {

    }
}
