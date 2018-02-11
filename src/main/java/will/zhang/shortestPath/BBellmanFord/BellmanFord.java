package will.zhang.shortestPath.BBellmanFord;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/2/6 0006 17:39.
 */
public class BellmanFord<Weight extends Number & Comparable>{

    /**
     * 图的引用
     */
    private WeightedGraph g;
    /**
     * 起始点
     */
    private int s;
    /**
     * distTo[i]存储从起始点s到i的最短路径长度
     */
    private Number[] distTo;
    /**
     * from[i]存储从起始点s到i的最短路径长度
     * 可以用来恢复整个最短路径
     */
    Edge<Weight>[] from;
    /**
     * 标记图中是否有负权环
     */
    boolean hasNegativeCycle;

    public BellmanFord(WeightedGraph graph, int s){
        g = graph;
        this.s = s;
        distTo = new Number[g.V()];
        from = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            from[i] = null;
        }
        // 设置distTo[s] = 0, 并且让from[s]不为NULL, 表示初始s节点可达且距离为0
        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight)(Number)0.0);

        //Bellman-Ford过程
        //进行V-1次循环, 每一次循环求出从起点到其余所有点, 最多使用pass步可到达的最短距离
        for (int pass = 1; pass < g.V(); pass++) {
            //每次循环中对所有的边进行一遍松弛操作
            //遍历所有边的方式是先遍历所有的顶点, 然后遍历和所有顶点相邻的所有边
            for (int i = 0; i < g.V(); i++) {
                for (Object item : g.adj(i)) {
                    Edge<Weight> e = (Edge<Weight>) item;

                    //对于每一个遍首先判断e.V()可达
                    //之后看如果e.W()以前没有到达过, 显然我们可以更新distTo[e.W()]
                    //或者e.W()以前虽然到达过, 但是通过这个e我们可以获得一个更短的距离, 即可以进行一次松弛操作, 我们也可以更新distTo[e.W()]
                    if(from[e.V()] != null && (from[e.W()] == null || distTo[e.V()].doubleValue() + e.wt().doubleValue() < distTo[e.W()].doubleValue())){
                        distTo[e.W()] = distTo[e.V()].doubleValue() + e.wt().doubleValue();
                        from[e.W()] = e;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }

    /**
     * 返回图中是否有负权环
     * @return
     */
    boolean negativeCycle(){
        return hasNegativeCycle;
    }

    /**
     * 返回从s点到w点的最短路径长度
     * @param w
     * @return
     */
    Number shortestPathTo(int w){
        assert w >= 0 && w < g.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    /**
     * 判断从s点到w点是否联通
     * @param w
     * @return
     */
    boolean hasPathTo(int w){

        assert (w >= 0 && w < g.V());
        return from[w] != null;
    }

    /**
     * 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
     * @param w
     * @return
     */
    Vector<Edge<Weight>> shortestPath(int w){

        assert w >= 0 && w < g.V() ;
        assert !hasNegativeCycle ;
        assert hasPathTo(w) ;

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<Weight>> s = new Stack<Edge<Weight>>();
        Edge<Weight> e = from[w];
        while( e.V() != this.s ){
            s.push(e);
            e = from[e.V()];
        }
        s.push(e);

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Edge<Weight>> res = new Vector<Edge<Weight>>();
        while( !s.empty() ){
            e = s.pop();
            res.add(e);
        }

        return res;
    }

    /**
     * 打印从s点到w点的路径
     * @param w
     */
    void showPath(int w){

        assert( w >= 0 && w < g.V() );
        assert( !hasNegativeCycle );
        assert( hasPathTo(w) );

        Vector<Edge<Weight>> res = shortestPath(w);
        for( int i = 0 ; i < res.size() ; i ++ ){
            System.out.print(res.elementAt(i).V() + " -> ");
            if( i == res.size()-1 )
                System.out.println(res.elementAt(i).W());
        }
    }

    /**
     * 判断图中是否有负权环
      */
    boolean detectNegativeCycle(){

        for( int i = 0 ; i < g.V() ; i ++ ){
            for( Object item : g.adj(i) ){
                Edge<Weight> e = (Edge<Weight>)item;
                if( from[e.V()] != null && distTo[e.V()].doubleValue() + e.wt().doubleValue() < distTo[e.W()].doubleValue() )
                    return true;
            }
        }

        return false;
    }
}
