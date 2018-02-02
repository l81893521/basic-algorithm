package will.zhang.graphBasic.EFindingAPath;

import java.util.Stack;

/**
 * Created by Will.Zhang on 2018/1/30 0030 15:44.
 */
public class Main {

    public static void main(String[] args) {
        String filename = Main.class.getClass().getResource("/graph").getPath() + "/testG.txt";

        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();

        System.out.println();
        Path path = new Path(g, 0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);

    }
}
