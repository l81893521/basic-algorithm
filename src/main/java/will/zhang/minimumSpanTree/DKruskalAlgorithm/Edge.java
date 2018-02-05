package will.zhang.minimumSpanTree.DKruskalAlgorithm;

/**
 * Created by Will.Zhang on 2018/2/1 0001 11:48.
 * 边
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge>{

    /**
     * 边的两个点
     */
    private int a, b;
    /**
     * 边的权值
     */
    private Weight weight;

    public Edge(Edge<Weight> e) {
        this.weight = e.weight;
        this.a = e.a;
        this.b = e.b;
    }

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    /**
     * 返回第一个定点
     * @return
     */
    public int V(){
        return a;
    }

    /**
     * 返回第二个顶点
     * @return
     */
    public int W(){
        return b;
    }

    /**
     * 返回权值
     * @return
     */
    public Weight wt(){
        return weight;
    }

    /**
     * 给定一个顶点, 返回另一个顶点
     * @param x
     * @return
     */
    public int other(int x){
        assert x == a || x == b;
        return x == a ? b : a;
    }

    // 输出边的信息
    public String toString(){
        return "" + a + "-" + b + ": " + weight;
    }

    /**
     * 边之间的比较
     * @param that
     * @return
     */
    @Override
    public int compareTo(Edge that) {
        if(weight.compareTo(that.weight) < 0){
            return -1;
        }else if(weight.compareTo(that.weight) > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
