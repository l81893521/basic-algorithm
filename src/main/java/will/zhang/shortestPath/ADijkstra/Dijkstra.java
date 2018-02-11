package will.zhang.shortestPath.ADijkstra;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/2/6 0006 15:31.
 * Dijkstra算法求最短路径
 */
public class Dijkstra<Weight extends Number & Comparable> {

    /**
     * 图的引用
     */
    private WeightedGraph g;
    /**
     * 起始点source
     */
    private int s;
    /**
     * distTo[i]存储从起始点s到i的最短路径长度
     */
    private Number[] distTo;
    /**
     * 标记数组, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;
    /**
     * from[i]记录最短路径中, 到达i点的边是哪一条
     * 可以用来恢复整个最短路径
     */
    private Edge<Weight>[] from;


    /**
     * 构造函数
     * 使用Dijkstra算法求最短路径
     * @param graph
     * @param s
     */
    public Dijkstra(WeightedGraph graph, int s){
        //算法初始化
        g = graph;

        assert s >= 0 && s <g.V();
        this.s = s;
        distTo = new Number[g.V()];
        marked = new boolean[g.V()];
        from = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = 0.0;
            marked[i] = false;
            from[i] = null;
        }
        //使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<Weight>(g.V());

        //对起始点s进行初始化, 自身和自身的距离是0, 并且标记为以访问
        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight)(Number)0.0);
        ipq.insert(s, (Weight) distTo[s]);
        marked[s] = true;

        while(!ipq.isEmpty()){
            int v = ipq.extractMinIndex();

            //distTo[v]就是s到v的最短距离
            marked[v] = true;

            //对v的所有相邻节点进行更新
            for (Object item: g.adj(v)) {
                //遍历取出所有邻边

                //邻边
                Edge<Weight> e = (Edge<Weight>) item;

                int w = e.other(v);
                //如果从s点到w点的最短路径还没找到
                if(!marked[w]){
                    //如果w点已经没有访问过
                    //或者访问过, 但是通过当前v点到w点距离更短, 则进行更新
                    if(from[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() < distTo[w].doubleValue()){
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;
                        if(ipq.contain(w)){
                            ipq.change(w, (Weight) distTo[w]);
                        }else{
                            ipq.insert(w, (Weight) distTo[w]);
                        }
                    }
                }
            }
        }

    }

    /**
     * 返回从s点到w点的最短路径长度
     * @param w
     * @return
     */
    Number shortestPathTo(int w){
        assert w >= 0 && w < g.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    /**
     * 判断从s点到w点是否联通
     * @param w
     * @return
     */
    boolean hasPathTo(int w){
        assert w >= 0 && w < g.V();
        return marked[w];
    }

    Vector<Edge<Weight>> shortestPath(int w){
        assert w >= 0 && w < g.V();
        assert hasPathTo(w);

        //通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<Weight>> s = new Stack<>();
        Edge<Weight> e = from[w];
        while(e.V() != this.s){
            s.push(e);
            e = from[e.V()];
        }
        s.push(e);

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Edge<Weight>> res = new Vector<Edge<Weight>>();
        while( !s.empty() ){
            e = s.pop();
            res.add( e );
        }

        return res;
    }

    /**
     * 打印从s点到w点的路径
     * @param w
     */
    void showPath(int w){

        assert w >= 0 && w < g.V();
        assert hasPathTo(w);

        Vector<Edge<Weight>> path =  shortestPath(w);
        for( int i = 0 ; i < path.size() ; i ++ ){
            System.out.print( path.elementAt(i).V() + " -> ");
            if( i == path.size()-1 )
                System.out.println(path.elementAt(i).W());
        }
    }

}
