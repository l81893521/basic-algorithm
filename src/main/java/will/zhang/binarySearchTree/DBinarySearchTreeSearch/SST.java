package will.zhang.binarySearchTree.DBinarySearchTreeSearch;

/**
 * Created by Will.Zhang on 2018/1/18 0018 14:36.
 * 顺序查找表
 */
public class SST<Key extends Comparable<Key>, Value> {

    /*
    顺序查找表的节点为私有的类, 外界不需要了解具体实现
    内部本质是一个链表
     */
    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    /**
     * 表头
     */
    private Node head;
    /**
     * 节点个数
     */
    private int count;

    public SST() {
        head = null;
        count = 0;
    }

    /**
     * 返回节点个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 返回顺序查找表是否为空
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * 像顺序查找表插入一个新的<key, value>数据对
     * @param key
     * @param value
     */
    public void insert(Key key, Value value){
        Node node = head;
        while(node != null){
            //找到了同样大小的key节点
            //则当前节点不需要插入, 直接更新
            if(key.compareTo(node.key) == 0){
                node.value = value;
                return;
            }
            node = node.next;
        }
        //当没有重复的key, 则将新的节点插入在表头
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        count ++;
    }

    /**
     * 查看顺序查找表中是否包含键值为key的节点
     * @param key
     * @return
     */
    public boolean contain(Key key){
        Node node = head;
        while(node != null){
            if(key.compareTo(node.key) == 0){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 在顺序查找表中查找key所对应的value,如果不存在则返回null
     * @param key
     * @return
     */
    public Value search(Key key){
        Node node = head;
        while (node != null){
            if(key.compareTo(node.key) == 0){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(Key key){
        //表头为空直接退出
        if(head == null) return;

        if(key.compareTo(head.key) == 0){
            Node delNode = head;
            head = head.next;
            delNode.next = null;
            count--;
            return;
        }


        Node node = head;
        while( node.next != null && node.next.key.compareTo(key) != 0 )
            node = node.next;

        if( node.next != null ){
            Node delNode = node.next;
            node.next = delNode.next;
            delNode.next = null;
            count --;
            return;
        }
    }
}
