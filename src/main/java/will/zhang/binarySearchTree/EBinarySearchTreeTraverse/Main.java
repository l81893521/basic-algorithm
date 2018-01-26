package will.zhang.binarySearchTree.EBinarySearchTreeTraverse;

/**
 * Created by Will.Zhang on 2018/1/18 0018 16:29.
 */
public class Main {

    /**
     * 测试二分搜索树的前, 中, 后序遍历
     * @param args
     */
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = new Integer((int)(Math.random()*M));
            //key和value取值一样
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        //测试二分搜索树size
        System.out.println("size: " + bst.size());
        System.out.println();

        //测试二分搜索树前序遍历
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        //测试二分搜索树中序遍历
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        //测试二分搜索树后续遍历
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

    }
}
