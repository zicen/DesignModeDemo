package arithmetic.graph;

import java.util.Vector;

/**
 * Created by Administrator on 2018/4/22 0022.
 * 稀疏图 - 邻接表
 * 0  1
 * 1  0  2  3
 * 2  1  3
 * 3  1  2
 */
public class SparseGraph extends Graph {
    private boolean directed; //是否是有向图
    private Vector<Integer>[] g; //保存此两个节点之间是否有连接

    public SparseGraph() {
    }
    public void show(){
        for (int i = 0; i < n; i++) {
            System.out.print("line"+i+":");
            for (int i1 = 0; i1 < g[i].size(); i1++) {
                System.out.print("  "+g[i].get(i1));
            }
            System.out.println();
        }
    }
    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = (Vector<Integer>[])new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }
    public void addEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }

        m++;

    }
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w)
                return true;
            return false;
        }
        return false;
    }
}
