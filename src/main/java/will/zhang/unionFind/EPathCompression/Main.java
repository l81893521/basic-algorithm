package will.zhang.unionFind.EPathCompression;


/**
 * Created by Will.Zhang on 2018/1/24 0024 16:52.
 */
public class Main {

    public static void main(String[] args) {
        int n = 1000000;
        //虽然isConnected只需要O(1)的事件, 但由于union操作需要O(n)的时间
        //总体测试过程的算法复杂度是O(n^2)的
//        UnionFindTestHelper.testUF1(n);
//        UnionFindTestHelper.testUF2(n);
        UnionFindTestHelper.testUF3(n);
        UnionFindTestHelper.testUF4(n);
        UnionFindTestHelper.testUF5(n);
    }
}
