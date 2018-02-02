package will.zhang.graphBasic.FBFSAndShortestPath;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/1/31 0031 11:57.
 */
public class ShortestPath {

    /**
     * 图的引用
     */
    Graph g;
    /**
     * 记录dfs(deep first search)的过程中节点是否被访问
     */
    private boolean[] visited;
    /**
     * 起始点(source)
     */
    private int s;
    /**
     * 记录路径, from[i]表示路径上i的上一个节点
     */
    private int[] from;
    /**
     * 记录路径中节点的次序.order[i]表示i节点在路径中的次序
     */
    private int[] ord;

    /**
     * 构造函数, 求出无权图的联通分量
     * @param graph
     */
    public ShortestPath(Graph graph, int s) {
        //算法初始化
        this.g = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        ord = new int[graph.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }


        //无向图最短路径算法, 从s开始广度优先遍历整张图
        LinkedList<Integer> q = new LinkedList<>();

        q.push(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()){
            int v = q.pop();
            for (int i : g.adj(v)) {
                if(!visited[i]){
                    q.push(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }
        }

    }

    /**
     * 点s到w是否存在路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        return visited[w];
    }

    /**
     * 查询从s点到w点的路径, 存放在vec中
     * @param w
     * @return
     */
    Vector<Integer> path(int w){
        assert hasPath(w);

        Stack<Integer> s = new Stack<>();
        //通过from数组逆向查找到从s到w的路径, 存放到盏中
        int p = w;
        while (p != -1){
            s.push(p);
            p = from[p];
        }

        //从盏中依次取出元素, 获得顺序的从s到w的路径
        Vector<Integer> res = new Vector<>();
        while (!s.empty()){
            res.add(s.pop());
        }
        return res;
    }

    /**
     * 打印出从s点到w点的路径
     * @param w
     */
    void showPath(int w){
        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    /**
     * 查看从s点到w点的最短路径长度
     * 若不可达,返回-1
     * @param w
     * @return
     */
    public int length(int w){
        assert w >= 0 && w < g.V();
        return ord[w];
    }

}
